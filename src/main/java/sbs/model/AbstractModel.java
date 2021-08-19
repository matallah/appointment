package sbs.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
public abstract class AbstractModel<Long extends Serializable> implements Serializable {
    @Transient
    @JsonIgnore
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    @JsonIgnore
    private static final long serialVersionUID = -6323358535657100144L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @Column(name = "name")
    @JsonIgnore
    private String name;
    @Column(name = "remarks")
    @JsonIgnore
    private String remarks;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creationDate;
    @Column(name = "last_modify_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date lastModifyDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_user")
    @JsonIgnore
    private Long creationUser;
    @Column(name = "last_modify_user")
    @JsonIgnore
    private Long lastModifyUser;
    @Column(name = "deleted")
    @JsonIgnore
    private boolean deleted;

    public AbstractModel() {
    }

    public AbstractModel(Long id) {
        this.id = id;
    }

    public AbstractModel(String name) {
        this.name = name;
    }

    public AbstractModel(String name, Date creationDate, Long creationUser) {
        this.name = name;
        this.creationDate = creationDate;
        this.creationUser = creationUser;
    }

    public AbstractModel(Long id, Date lastModifyDate, Long lastModifyUser) {
        this.id = id;
        this.lastModifyDate = lastModifyDate;
        this.lastModifyUser = lastModifyUser;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public Long getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(Long creationUser) {
        this.creationUser = creationUser;
    }

    public Long getLastModifyUser() {
        return lastModifyUser;
    }

    public void setLastModifyUser(Long lastModifyUser) {
        this.lastModifyUser = lastModifyUser;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    @JsonIgnore
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AbstractModel<?> other = (AbstractModel<?>) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
