package startcleaningup.before;

public class LaboratoryNegations {

    Microscope microscope;

    public LaboratoryNegations(Microscope microscope) {
        this.microscope = microscope;
    }

    public Result analyze(Sample sample) {
        if (microscope.isInorganic(sample)) {
            return Result.INORGANIC;
        } else {
            return analyzeOrganic(sample);
        }
    }

    private Result analyzeOrganic(Sample sample) {
        if (!microscope.isHumanoid(sample)) {
            return Result.ALIEN;
        } else {
            return Result.HUMANOID;
        }
    }
}

