package org.serratec.backend.redesocial.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class UsuarioPerfilPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	@JsonIgnore
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_perfil")
	@JsonIgnore
	private Perfil perfil;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public int hashCode() {
		return Objects.hash(perfil, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioPerfilPK other = (UsuarioPerfilPK) obj;
		return Objects.equals(perfil, other.perfil) && Objects.equals(usuario, other.usuario);
	}
}