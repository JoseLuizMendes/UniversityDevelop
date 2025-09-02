package StackPageNavigation;

public class Page {

	private String titulo;
	private String url;

	public Page(String titulo, String url) {
		this.titulo = titulo;
		this.url = url;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "\nTítulo: " + titulo + ", URL: " + url;
	}

}
