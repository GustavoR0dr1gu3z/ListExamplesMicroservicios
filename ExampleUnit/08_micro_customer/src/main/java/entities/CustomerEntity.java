package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class CustomerEntity {
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Id
		private long id;
		private String nombre;
		private String phone;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		
		
}
