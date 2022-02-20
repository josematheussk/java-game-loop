package gl;

import java.util.ArrayList;

public class Game implements Runnable{
	
	private boolean isRunning;
	private Thread thread;
	
	private ArrayList<Entity> entities;
	
	public Game(){
		entities.add(new Entity());
		
		for(int i = 0;i < entities.size(); i++) {
			Entity e = entities.get(0);
		}
	}
	
	public void main(String[] args) {
		Game game = new Game();
		game.start();
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
	}

	public void tick() {
		System.out.println("Tick");
	}
	
	public void render() {
		System.out.println("Render");
	}
	
	@Override
	public void run() {
	
		while(isRunning) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
