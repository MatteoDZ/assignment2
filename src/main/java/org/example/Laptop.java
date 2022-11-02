package org.example;

public class Laptop extends Product{
    private int diskSpace;
    private int screenSize;
    private String diskType;
    private String cpuType;
    private String gpuType;
    private String oS;

    public Laptop(int productId, String category, String name, String description, String brandName, String imageUrl, float price, int stock, String shortDescription, int diskSpace, int screenSize, String diskType, String cpuType, String gpuType, String oS) {
        super(productId, category, name, description, brandName, imageUrl, price, stock, shortDescription);
        this.diskSpace = diskSpace;
        this.screenSize = screenSize;
        this.diskType = diskType;
        this.cpuType = cpuType;
        this.gpuType = gpuType;
        this.oS = oS;
    }

    public int getDiskSpace() {
        return diskSpace;
    }

    public void setDiskSpace(int diskSpace) {
        this.diskSpace = diskSpace;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public String getDiskType() {
        return diskType;
    }

    public void setDiskType(String diskType) {
        this.diskType = diskType;
    }

    public String getCpuType() {
        return cpuType;
    }

    public void setCpuType(String cpuType) {
        this.cpuType = cpuType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getoS() {
        return oS;
    }

    public void setoS(String oS) {
        this.oS = oS;
    }
}
