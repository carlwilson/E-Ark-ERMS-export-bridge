/**
 * This class is generated by jOOQ
 */
package dk.magenta.eark.erms.db.connector.tables.records;


import dk.magenta.eark.erms.db.connector.tables.Profiles;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProfilesRecord extends UpdatableRecordImpl<ProfilesRecord> implements Record4<String, String, String, String> {

    private static final long serialVersionUID = -1472976015;

    /**
     * Setter for <code>exm.Profiles.profileName</code>.
     */
    public void setProfilename(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>exm.Profiles.profileName</code>.
     */
    public String getProfilename() {
        return (String) get(0);
    }

    /**
     * Setter for <code>exm.Profiles.url</code>.
     */
    public void setUrl(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>exm.Profiles.url</code>.
     */
    public String getUrl() {
        return (String) get(1);
    }

    /**
     * Setter for <code>exm.Profiles.userName</code>.
     */
    public void setUsername(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>exm.Profiles.userName</code>.
     */
    public String getUsername() {
        return (String) get(2);
    }

    /**
     * Setter for <code>exm.Profiles.password</code>.
     */
    public void setPassword(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>exm.Profiles.password</code>.
     */
    public String getPassword() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Profiles.PROFILES.PROFILENAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Profiles.PROFILES.URL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Profiles.PROFILES.USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Profiles.PROFILES.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getProfilename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProfilesRecord value1(String value) {
        setProfilename(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProfilesRecord value2(String value) {
        setUrl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProfilesRecord value3(String value) {
        setUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProfilesRecord value4(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProfilesRecord values(String value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProfilesRecord
     */
    public ProfilesRecord() {
        super(Profiles.PROFILES);
    }

    /**
     * Create a detached, initialised ProfilesRecord
     */
    public ProfilesRecord(String profilename, String url, String username, String password) {
        super(Profiles.PROFILES);

        set(0, profilename);
        set(1, url);
        set(2, username);
        set(3, password);
    }
}