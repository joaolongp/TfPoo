public class Bobao extends Personagem {
    public Bobao(int linInicial, int colInicial) {
        super(10, "Civil", linInicial, colInicial);
    }

    @Override
    public void infecta(){
        if (this.infectado()){
            return;
        }
        super.infecta();
        this.setImage("Civil Infectado");
        this.getCelula().setImageFromPersonagem();   
    }

    @Override
    public void cura(){
        if(this.infectado()){
            super.cura();
            this.setImage("Civil");
            this.getCelula().setImageFromPersonagem();
        }   
    }

    @Override
    public void morre() {
        super.morre();
        this.setImage("Civil Morto");
        this.getCelula().setImageFromPersonagem();
    }

    @Override
    public void atualizaPosicao() {
        // Não se mexe
    }

    @Override
    public void influenciaVizinhos() {
        // Não influencia ninguém
    }

    @Override
    public void verificaEstado() {
        // Se esta morto retorna
        if (!this.estaVivo()){
            this.morre();
        }
        // Se esta infectado perde energia a cada passo
        if (this.infectado()) {
            diminuiEnergia(2);
            // Se não tem mais energia morre
            if (this.getEnergia() == 0) {
                this.setImage("Civil Morto");
                this.getCelula().setImageFromPersonagem();
            }
        }
    }
}