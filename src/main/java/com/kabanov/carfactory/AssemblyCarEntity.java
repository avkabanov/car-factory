package com.kabanov.carfactory;

public class AssemblyCarEntity {
    private boolean qualityCheckPassed;
    
    public void paint() {
        System.out.println("Painting");            
    }
    
    public void assemblyMechanics() {
        System.out.println("Assembling mechanics");
    }

    public void assemblyInterior() {
        System.out.println("Assembling interior");
    }

    public void polishing() {
        System.out.println("Polishing");
    }

    public void setQualityCheckPassed() {
        qualityCheckPassed = true;
    }
    
    public boolean isQualityCheckPassed() {
        return qualityCheckPassed;
    }
    
    public Car build() {
        return new Car();
    }
}
