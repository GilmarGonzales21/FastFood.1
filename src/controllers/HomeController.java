package controllers;

import javax.swing.SwingUtilities;
import core.Controller;
import views.ComboListView;
import views.HomeView;
import views.NewComboView;


/**
 * Main controller. It will be responsible for program's main screen behavior.
 */
public class HomeController extends Controller 
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	private HomeView homeView;
	private final ComboListController listController= new ComboListController();
        private final NewComboController newController = new NewComboController(listController);
	
	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	@Override
	public void run()
	{
		// Initializes others controllers
		listController.run();
		newController.run();
		
		// Initializes HomeView
		homeView = new HomeView(this, mainFrame);
		addView("HomeView", homeView);
		
		// Displays the program window
		mainFrame.setVisible(true);
	}
	
	
	//-----------------------------------------------------------------------
	//		Getters
	//-----------------------------------------------------------------------
    public ComboListView getComboListView() {
        return listController.getView();
    }

    public NewComboView getNewComboView() {
        return newController.getView();
    }
}