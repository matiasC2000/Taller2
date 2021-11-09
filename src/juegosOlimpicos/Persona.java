package juegosOlimpicos;

public class Persona {
		private String nombre;
		private String apellido;
		private int edad;
		private String email;
		private long telefono;
		
		public Persona(String nombre, String apellido, int edad) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.edad = edad;
		}
	
		
		
		public Persona() {
			super();
		}




		public String getEmail() {
			return email;
		}





		public void setEmail(String email) {
			this.email = email;
		}





		public long getTelefono() {
			return telefono;
		}





		public void setTelefono(long telefono) {
			this.telefono = telefono;
		}	
		
		
		
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public int getEdad() {
			return edad;
		}
		public void setEdad(int edad) {
			this.edad = edad;
		}
		

}
