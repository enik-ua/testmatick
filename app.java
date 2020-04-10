import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class MyWindowApp extends JFrame{
    public static Figure figures[];
    public void paint(Graphics g){
        int posy = 100;
        for (int i=0;i<=figures.length-1;i++){
            Figure figure = figures[i];
            g.setColor(getColor(figure.color));
	    figure.draw(100,posy,g);
            posy = posy + figure.side + 10;
        }
    }
    public MyWindowApp(){
        super("Shape generator"); //Заголовок окна
        setBounds(1000, 1000, 1000, 1000); //Если не выставить 
                                   //размер и положение 
                                   //то окно будет мелкое и незаметное
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при 
                                                    //закрытии окна закрывалась и программа,
                                                    //иначе она останется висеть в процессах
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Количество фигур: ");
        figures = new Figure[in.nextInt()];
        in.close();
        for (int i=0;i<=figures.length-1;i++){
            Figure figure = new Figure();
            figure.side = 1+(int) (Math.random()*100);
            figure.type = (int) (Math.random()*4);
            figure.color = (int) (Math.random()*10);
            System.out.println(figure.description());
            figures[i] = figure;
        }

        MyWindowApp app = new MyWindowApp(); //Создаем экземпляр нашего приложения
        app.setVisible(true); //С этого момента приложение запущено!

    }
    public static Color getColor(int color){
	Color obColor;
	switch (color) {
            case 0:
		obColor = new Color(255,0,0); //Красный
		break;
	    case 1:
		obColor = new Color(255,255,0); //Жёлтый
		break;
	    case 2:
		obColor = new Color(0,128,0); //Зеленый
		break;
	    case 3:
		obColor = new Color(0,0,255); //Синий
		break;
	    case 4:
		obColor = new Color(0,0,0); //Чёрный
		break;
	    case 5:
		obColor = new Color(255,255,255); //Белый
		break;
	    case 6:
		obColor = new Color(255,69,0); //Оранжевый
		break;
	    case 7:
		obColor = new Color(135,206,250); //Голубой
		break;
	    case 8:
		obColor = new Color(128,0,128); //Фиолетовый
		break;
	    case 9:
		obColor = new Color(255,192,203); //Розовый
		break;
	    default:
		obColor = new Color(0,0,0);		
	}
    return obColor;}
}
class Figure{
    public int side;
    public int type;
    public int color;
    public String description(){
        double p;
        double s;
        String str;
        switch (type){
            case 0:
                s = side*side;
                str ="Прямоугольник - площадь: "+ s +", цвет: " + getColorName(color);
                break;
            case 1:
                p = (3*side)/2;
                s = Math.sqrt(p*(p-side)*(p-side)*(p-side));
                str ="Триугольник - площадь: "+ s +", цвет: " + getColorName(color);
                break;
            case 2:
                s = Math.PI * Math.pow(side,2);
                str ="Круг - площадь: "+ s + ", цвет: " + getColorName(color);
                break;
            case 3:
                p = (side+(3/2*side))/2;
                s = Math.sqrt((p-side)*(p-side/2)*(p-side/2)*(p-side/2));
                str ="Трапеция - площадь: "+ s + ", цвет: " + getColorName(color);
                break;
            default:
                str ="Фигура не определена";
        }
        return str;

    }
    public void draw(int posx,int posy, Graphics g){
        switch(type){
            case 0:
                g.drawLine(posx,posy,posx+side,posy);
                g.drawLine(posx+side,posy,posx+side,posy+side);
                g.drawLine(posx+side,posy+side,posx,posy+side);
                g.drawLine(posx,posy+side,posx,posy);
                break;
            case 1:
                g.drawLine(posx+side/2,posy,posx+side,posy+side);
                g.drawLine(posx+side,posy+side,posx,posy+side);
                g.drawLine(posx,posy+side,posx+side/2,posy);
                break;
            case 2:
                g.drawOval(posx,posy,2*side,2*side);
                break;
            case 3:
                g.drawLine(posx,posy+side,posx+(int)(0.25*side),posy);
                g.drawLine(posx+(int)(0.25*side),posy,posx+(int)(0.75*side),posy);
                g.drawLine(posx+(int)(0.75*side),posy,posx+side,posy+side);
                g.drawLine(posx+side,posy+side,posx,posy+side);
                break;
        }
    }
    public static String getColorName(int color){
	String str;
	switch (color) {
            case 0:
		str = "Красный";
		break;
	    case 1:
		str = "Жёлтый";
		break;
	    case 2:
		str = "Зеленый";
		break;
	    case 3:
		str = "Синий";
		break;
	    case 4:
		str = "Чёрный";
		break;
	    case 5:
		str = "Белый";
		break;
	    case 6:
		str = "Оранжевый";
		break;
	    case 7:
		str = "Голубой";
		break;
	    case 8:
		str = "Фиолетовый";
		break;
	    case 9:
		str = "Розовый";
		break;
	    default:
		str = "Неопределен";
	}
    return str;}

}
