package manager;

import java.util.ArrayList;

import training.Training;
import training.TrainingManager;

/**
 * Clase encargada de gestionar el estado del m�vil e interactuar con los entrenamientos.
 * @author Robert
 *
 */
public class DetectionManager {

	/**
	 * Nos indica si el m�vil est� parado o si est� en movimiento.
	 * true = parado.
	 * false = movimiento. 
	 */
	private  boolean isStopped;
	
	/**
	 * TrainingManager.
	 */
	private  TrainingManager trainingManager;
	
	/**
	 * V�deo M�nager.
	 */
	private VideoManager videoManager;
	
	/**
	 * Instancia est�tica de la propia clase.
	 */
	private static DetectionManager manager;
	
	/**
	 * COnstructor privado.
	 */
	private DetectionManager(){
		isStopped = false;
		trainingManager = new TrainingManager();
		videoManager = new VideoManager();
	}
	
	/**
	 * S�lo hay una instancia de la clase detectionManager. 
	 * @return Devuelve la instancia del detection managar.
	 */
	public static DetectionManager getInstance(){
		if(manager==null){
			manager = new DetectionManager();
		}
		return manager;
	}
	
	public ArrayList<Training> getTrainings(){
		return trainingManager.getTrainigs();
		
	}
	
	public void setTrainings(ArrayList<Training> newTrainings){
		if(newTrainings!=null){
			this.trainingManager.setTrainings(newTrainings);
		}
	}
	
	public void setTrainingState(String name, boolean state){
		trainingManager.setTrainingState(name, state);
		
	}
	
	public void setIsStopped(boolean isStopped){
		this.isStopped = isStopped;
	}
	
	public boolean getIsStopped(){
		return this.isStopped;
	}
	
	public void saveTrainings(){
		trainingManager.saveTrainings();
	}
	
	public void addTraining(String name, String fileName, String notice, boolean state){
		trainingManager.addTraining(name, fileName, notice, state);
	}
	
	public VideoManager getVideoManager(){
		return videoManager;
	}
}
