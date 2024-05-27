public enum 音符{
    四分音符(0.25),八分音符(0.125),十六分音符(0.0625);
    ;
    public double 时长;
    音符(double 时长){
        this.时长 = 时长;
    }
}
