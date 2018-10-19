package com.cursoandroid.firebaseapp.firebaseapp;

public class Produtos {

    private String corProduto;
    private String DescricaoProduto;
    private String fabricante;

    public Produtos() {
    }

    public String getCorProduto() {
        return corProduto;
    }

    public void setCorProduto(String corProduto) {
        this.corProduto = corProduto;
    }

    public String getDescricaoProduto() {
        return DescricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        DescricaoProduto = descricaoProduto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}
