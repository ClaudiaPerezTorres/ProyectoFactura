package factura;

class Producto {

	public Producto(String codigo, String descripcion, int cantidad, int precioVenta, double impuesto) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precioVenta = precioVenta;
		this.impuesto = impuesto;
		this.subtotal=getSubtotal();
		this.iva=getIva();
		this.total=getTotal();
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
	public double getIva() {
		this.iva = this.subtotal*(this.impuesto/100);
		return Math.round(iva);
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getTotal() {
		this.total = this.subtotal + this.iva;
		return Math.round(total);
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getSubtotal() {
		double impo = 1+(this.impuesto/100);
		this.subtotal = Math.round(this.precioVenta * this.cantidad / impo);
		return Math.round(subtotal);
	}
	
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	private String codigo, descripcion;
	private  int precioVenta, cantidad;
	private double impuesto, iva, total, subtotal;
}
