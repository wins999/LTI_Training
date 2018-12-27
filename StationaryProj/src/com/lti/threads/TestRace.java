package com.lti.threads;
class Animal
{  void speak()
{ System.out.println("speak"); } }
class Dog extends Animal{ 
void speak(){System.out.println("woof!"); } } 

class Cat extends Animal{  void speak()
{System.out.println("meow!"); } } 
public class TestRace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Racer r = new Racer(10);
		r.start();
		r.interrupt(); 
		
		Racer r1 = new Racer(1);
		r1.start();
		r1.interrupt(); 
		
		Runnable r15 = new RunnableRacer();
		Thread th = new Thread(r15);
		th.start();
		th.setName("RacerRunnable..");
		th.setPriority(10);
	}*/
	 
	int i=0,k=0; for (i=1;i<20;i++) {  
        int j=i*2;           
                   k=j*k; 
                   System.out.println(j);
                    } for
                     (int m=1;m<10;m++)
                      {        
System.out.println(m);    
      } //System.out.println("Value is "+m);
	}
}
