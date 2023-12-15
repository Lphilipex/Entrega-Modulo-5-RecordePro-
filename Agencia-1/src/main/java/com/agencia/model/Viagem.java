package com.agencia.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "viagens")
public class Viagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destino;
    
    
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date dataPartida; 
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataRetorno;
    private BigDecimal preco;
    private int vagasDisponiveis;

    public Viagem() {
       
    }

    // Construtor com todos os campos
    public Viagem(Long id, String destino, Date dataPartida, Date dataRetorno, BigDecimal preco, int vagasDisponiveis) {
        this.id = id;
        this.destino = destino;
        this.dataPartida = dataPartida;
        this.dataRetorno = dataRetorno;
        this.preco = preco;
        this.vagasDisponiveis = vagasDisponiveis;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getDestino() {
        return destino;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public Date getDataRetorno() {
        return dataRetorno;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public String getDataPartidaString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(this.dataPartida);
	}

	public void adicionarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
}
