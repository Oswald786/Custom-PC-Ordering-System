package com.v1.Model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class BuiltPcModel {
    public PcComponentModel getCpu() {
        return cpu;
    }

    public void setCpu(PcComponentModel cpu) {
        this.cpu = cpu;
    }

    public PcComponentModel getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(PcComponentModel motherboard) {
        this.motherboard = motherboard;
    }

    public PcComponentModel getRam() {
        return ram;
    }

    public void setRam(PcComponentModel ram) {
        this.ram = ram;
    }

    public PcComponentModel getGpu() {
        return gpu;
    }

    public void setGpu(PcComponentModel gpu) {
        this.gpu = gpu;
    }

    public PcComponentModel getStorage() {
        return storage;
    }

    public void setStorage(PcComponentModel storage) {
        this.storage = storage;
    }

    public PcComponentModel getPsu() {
        return psu;
    }

    public void setPsu(PcComponentModel psu) {
        this.psu = psu;
    }

    public PcComponentModel getCaseUnit() {
        return caseUnit;
    }

    public void setCaseUnit(PcComponentModel caseUnit) {
        this.caseUnit = caseUnit;
    }

    public PcComponentModel getCooler() {
        return cooler;
    }

    public void setCooler(PcComponentModel cooler) {
        this.cooler = cooler;
    }

    private PcComponentModel cpu;
    private PcComponentModel motherboard;
    private PcComponentModel gpu;
    private PcComponentModel ram;
    private PcComponentModel storage;
    private PcComponentModel psu;
    private PcComponentModel caseUnit;
    private PcComponentModel cooler;
    public BuiltPcModel(){}

    public BuiltPcModel(PcComponentModel cpu, PcComponentModel motherboard, PcComponentModel gpu, PcComponentModel ram, PcComponentModel storage,
                        PcComponentModel psu, PcComponentModel caseUnit, PcComponentModel cooler) {
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
        this.psu = psu;
        this.caseUnit = caseUnit;
        this.cooler = cooler;
    }
}
