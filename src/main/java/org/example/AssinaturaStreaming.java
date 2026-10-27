package org.example;

public abstract class AssinaturaStreaming {
    private String nome;
    private Float valor;
    private String beneficios;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    protected abstract float getDesconto();


    public final String conseguePagarAssinatura(float precoMaximoCliente){
        if (precoMaximoCliente <= 0){
            throw new IllegalArgumentException("Valor passado deve ser maior que zero!");
        }

        if (this.getValor() == null){
            throw new IllegalStateException("Valor da assinatura não foi definido!");
        }

        if (precoMaximoCliente >= (this.getValor() * (1-this.getDesconto()))){
            return ("Cabe no seu bolso!");
        }else{
            return ("Tente uma assinatura mais em conta!");
        }
    }
}
