package Montes;

public class Montes {
	private String nombreMonte;
	private String provincia;
	private int altura;
	private String coordenadas;
	private String cordillera;
	private String ruta;
	
	
	public Montes() {
	
	}


	public Montes(String nombreMonte, String provincia, int altura, String coordenadas, String cordillera,
			String ruta) {
		this.nombreMonte = nombreMonte;
		this.provincia = provincia;
		this.altura = altura;
		this.coordenadas = coordenadas;
		this.cordillera = cordillera;
		this.ruta = ruta;
	}



	public String getNombreMonte() {
		return nombreMonte;
	}



	public void setNombreMonte(String nombreMonte) {
		this.nombreMonte = nombreMonte;
	}



	public String getProvincia() {
		return provincia;
	}



	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}



	public int getAltura() {
		return altura;
	}



	public void setAltura(int altura) {
		this.altura = altura;
	}



	public String getCoordenadas() {
		return coordenadas;
	}



	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}



	public String getCordillera() {
		return cordillera;
	}



	public void setCordillera(String cordillera) {
		this.cordillera = cordillera;
	}



	public String getRuta() {
		return ruta;
	}



	public void setRuta(String ruta) {
		this.ruta = ruta;
	}



	@Override
	public String toString() {
		return "Montes [nombreMonte=" + nombreMonte + ", provincia=" + provincia + ", altura=" + altura
				+ ", coordenadas=" + coordenadas + ", cordillera=" + cordillera + ", ruta=" + ruta + "]";
	}
	
	
}
