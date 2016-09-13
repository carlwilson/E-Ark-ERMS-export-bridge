package dk.magenta.eark.erms.ead;

import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;

import dk.magenta.eark.erms.Constants;

/**
 * 
 * @author andreas
 *
 */
public class MappingParser {

	private String mappingId;
	private ObjectTypeMap objectTypeMap;
	private Map<String, List<Hook>> hooks;
	private Map<String, Element> CElements;
	private Namespace mappingNamespace;
	private Document mappingDocument;
	private XmlHandler xmlHandler;

	public MappingParser(String mappingId, InputStream in) {
		this.mappingId = mappingId;
		mappingNamespace = Namespace.getNamespace(Constants.MAPPING_NAMESPACE);
		xmlHandler = new XmlHandlerImpl();
		buildMappingDocument(in);
	}

	/**
	 * Build the JDOM mapping.xml Document from an input stream (the mapping.xml
	 * has been validated earlier on)
	 * 
	 * @param in
	 *            stream containing the mapping.xml
	 * @return JDOM representation of the mapping.xml
	 */
	public Document buildMappingDocument(InputStream in) {
		mappingDocument = xmlHandler.readXml(in);
		return mappingDocument;
	}

	/**
	 * Extract the objectTypes from the mapping.xml and put these into an
	 * ObjectTypeMap
	 * 
	 * @return the ObjectTypeMap containing the datastructures
	 */
	public ObjectTypeMap getObjectTypes() {
		if (objectTypeMap != null) {
			return objectTypeMap;
		}
		objectTypeMap = new ObjectTypeMap();
		List<Element> objectTypes = MappingUtils.extractElements(mappingDocument, "objectType", mappingNamespace);
		for (Element objectType : objectTypes) {
			String semanticType = objectType.getAttributeValue("id");
			boolean leaf = Boolean.parseBoolean(objectType.getAttributeValue("leaf").trim());
			String cmisType = objectType.getTextTrim();
			objectTypeMap.addObjectType(semanticType, cmisType, leaf);
		}
		return objectTypeMap;
	}

	/**
	 * Gets map of hooks
	 * 
	 * @return map from semantic name to list of Hooks
	 */
	public Map<String, List<Hook>> getHooks() {
		if (hooks != null) {
			return hooks;
		}
		hooks = new HashMap<String, List<Hook>>();
		List<Element> templates = MappingUtils.extractElements(mappingDocument, "template", mappingNamespace);
		for (Element template : templates) {
			Element hooksElement = MappingUtils.extractElements(template, "hooks", mappingNamespace).get(0);
			List<Element> hookElements = MappingUtils.extractElements(hooksElement, "hook", mappingNamespace);
			List<Hook> hookList = new LinkedList<Hook>();
			for (Element hookElement : hookElements) {
				Hook hook = new Hook(hookElement.getAttributeValue("xpath"), hookElement.getTextTrim());
				hookList.add(hook);
			}
			hooks.put(template.getAttributeValue("id"), hookList);
		}
		return hooks;
	}

	public List<Hook> getHooksFromSemanticType(String semanticType) {
		getHooks();
		return hooks.get(semanticType);
	}

	public List<Hook> getHooksFromCmisType(String cmisType) {
		String semanticType = getObjectTypes().getSemanticTypeFromCmisType(cmisType);
		return getHooksFromSemanticType(semanticType);
	}

	public String getSemanticTypeFromCmisType(String cmisType) {
		return getObjectTypes().getSemanticTypeFromCmisType(cmisType);
	}

	/**
	 * Get map from semantic type to c element
	 * 
	 * @return map from semantic type to c element
	 */
	public Map<String, Element> getCElements() {
		if (CElements != null) {
			return CElements;
		}
		CElements = new HashMap<String, Element>();
		List<Element> templates = MappingUtils.extractElements(mappingDocument, "template", mappingNamespace);
		for (Element template : templates) {
			Element ead = MappingUtils.extractElements(template, "ead", mappingNamespace).get(0);
			Element c = ead.getChild("c", mappingNamespace);
			CElements.put(template.getAttributeValue("id"), c);
		}
		return CElements;
	}

	public Element getCElementFromSemanticType(String semanticType) {
		return getCElements().get(semanticType);
	}

	public Element getCElementFromCmisType(String cmisType) {
		String semanticType = getObjectTypes().getSemanticTypeFromCmisType(cmisType);
		return getCElementFromSemanticType(semanticType);
	}

	public String getMappingId() {
		return mappingId;
	}

	public Document getMappingDocument() {
		return mappingDocument;
	}

	public boolean isLeaf(String cmisType) {
		String semanticType = getObjectTypes().getSemanticTypeFromCmisType(cmisType);
		return getObjectTypes().isLeaf(semanticType);
	}
}
