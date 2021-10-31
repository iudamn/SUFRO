class CargarPartida {
    private int coordenada;
    private int statA;
    private int statB;
    private int statC;
    private int posicion;

    public CargarPartida(int coordenada, int statA, int statB, int statC, int posicion){
        this.coordenada=coordenada;
        this.statA=statA;
        this.statB=statB;
        this.statC=statC;
        this.posicion=posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPosicion() {
        return posicion;
    }

    public int getCoordenada() {
        return this.coordenada;
    }

    public int getStatA() {
        return this.statA;
    }

    public int getStatB() {
        return this.statB;
    }

    public int getStatC() {
        return this.statC;
    }

    public void setCoordenada(int coordenada) {
        this.coordenada = coordenada;
    }

    public void setStatA(int statA) {
        this.statA = statA;
    }

    public void setStatB(int statB) {
        this.statB = statB;
    }

    public void setStatC(int statC) {
        this.statC = statC;
    }
}