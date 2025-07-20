package com.v1.Model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class PcBuildModel {
    private String cpuId;
    private String motherboardId;
    private String gpuId;
    private String ramId;
    private String storageId;
    private String psuId;
    private String caseId;
    private String coolerId;

    public PcBuildModel() {}

    public PcBuildModel(String cpuId, String motherboardId, String gpuId,
                        String ramId, String storageId, String psuId,
                        String caseId, String coolerId) {
        this.cpuId = cpuId;
        this.motherboardId = motherboardId;
        this.gpuId = gpuId;
        this.ramId = ramId;
        this.storageId = storageId;
        this.psuId = psuId;
        this.caseId = caseId;
        this.coolerId = coolerId;
    }

    // Getters and setters

    public String getCpuId() {
        return cpuId;
    }

    public void setCpuId(String cpuId) {
        this.cpuId = cpuId;
    }

    public String getMotherboardId() {
        return motherboardId;
    }

    public void setMotherboardId(String motherboardId) {
        this.motherboardId = motherboardId;
    }

    public String getGpuId() {
        return gpuId;
    }

    public void setGpuId(String gpuId) {
        this.gpuId = gpuId;
    }

    public String getRamId() {
        return ramId;
    }

    public void setRamId(String ramId) {
        this.ramId = ramId;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public String getPsuId() {
        return psuId;
    }

    public void setPsuId(String psuId) {
        this.psuId = psuId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCoolerId() {
        return coolerId;
    }

    public void setCoolerId(String coolerId) {
        this.coolerId = coolerId;
    }
    public void logSelectedIds() {
        System.out.println("PcBuildModel Selected IDs:");
        System.out.println("CPU: " + cpuId);
        System.out.println("Motherboard: " + motherboardId);
        System.out.println("GPU: " + gpuId);
        System.out.println("RAM: " + ramId);
        System.out.println("Storage: " + storageId);
        System.out.println("PSU: " + psuId);
        System.out.println("Case: " + caseId);
        System.out.println("Cooler: " + coolerId);
    }

}
