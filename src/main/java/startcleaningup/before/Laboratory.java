package startcleaningup.before;

public class Laboratory {

    Microscope microscope;
    
    public Laboratory(Microscope microscope) {
        this.microscope = microscope;
    }

    public Result analyze(Sample sample) {
        if (microscope.isInorganic(sample) == true) {
            return Result.INORGANIC;
        } else {
            return analyzeOrganic(sample);
        }
    }

    private Result analyzeOrganic(Sample sample) {
        if (microscope.isHumanoid(sample) == false) {
            return Result.ALIEN;
        } else {
            return Result.HUMANOID;
        }
    }
}
