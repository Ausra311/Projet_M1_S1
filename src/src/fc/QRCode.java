package fc;
public class QRCode extends Support {

	public QRCode(Film f) {
		super(f);
	}
    
    public void sortir_support(){
        automate.sortir_QRcode(film.get_id());
    }
}
