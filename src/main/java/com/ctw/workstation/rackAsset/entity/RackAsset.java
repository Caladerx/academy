package com.ctw.workstation.rackAsset.entity;
import jakarta.persistence.*;

@Entity
@Table(name="T_RACK_ASSET")
public class RackAsset {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rackAssetIdGenerator")
    @SequenceGenerator(name = "rackAssetIdGenerator", sequenceName = "SEQ_RACK_ASSET_ID")
    private long id;
    @Column(name = "ASSET_TAG", length = 10, nullable = false)
    private String assetTag;
    @Column(name = "RACK_ID")
    private long rackId;

    public RackAsset(long id, long rackId, String assetTag) {
        this.id = id;
        this.rackId = rackId;
        this.assetTag = assetTag;
    }

    public RackAsset() {

    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRackId() {
        return rackId;
    }

    public void setRackId(long rackId) {
        this.rackId = rackId;
    }
}
