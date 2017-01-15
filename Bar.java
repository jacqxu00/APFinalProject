public class Bar{
    private double totheight;
	private double potheight;
	private double kinheight;
	private double thermheight;
	
	public Bar(double tot, double pot, double kin, double therm){
		totheight = 300;
		potheight = (pot/tot)*300;
		kinheight = (kin/tot)*300;
		thermheight = (therm/tot)*300;
	}
	
	public void paint(Graphics g){
		//using dimensions of jpanel only
		Graphics2D totbar = (Graphics2D) g;
		totbar.setColor(new Color(000,075,025));
		totbar.drawRect(25,520 - totheight,70,totheight);
		totbar.fillRect(25,520 - totheight,70,totheight);
		Graphics2D potbar = (Graphics2D) g;
		potbar.setColor(new Color(000,075,025));
		potbar.drawRect(95+(70.0/3),520 - potheight,70,potheight);
		potbar.fillRect(25+(70.0/3),520 - potheight,70,potheight);
		Graphics2D kinbar = (Graphics2D) g;
		kinbar.setColor(new Color(000,075,025));
		kinbar.drawRect(165+(140.0/3),520 - kinheight,70,kinheight);
		kinbar.fillRect(95+(140.0/3),520 - kinheight,70,kinheight);
		Graphics2D thermbar = (Graphics2D) g;
		thermbar.setColor(new Color(000,075,025));
		thermbar.drawRect(305,520 - thermheight,70,thermheight);
		thermbar.fillRect(305,520 - thermheight,70,thermheight);
    }

}