package View;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class MenuBarPane {

	private MenuBar menuBar;

	private Menu fileMenu;
	private Menu studentMenu;
	private Menu facultyMenu;
	private Menu courseMenu;
	private Menu classroomMenu;
	private Menu textbookMenu;

	private Menu importMenu;
	private Menu exportMenu;

	// MenuItems in File Menu
	private MenuItem saveMenuItem;
	private MenuItem loadMenuItem;
	private MenuItem importStudentMenuItem;
	private MenuItem exportStudentMenuItem;
	private MenuItem importFacultyMenuItem;
	private MenuItem exportFacultyMenuItem;
	private MenuItem importCourseMenuItem;
	private MenuItem exportCourseMenuItem;
	private MenuItem importClassroomMenuItem;
	private MenuItem exportClassroomMenuItem;
	private MenuItem importTextbookMenuItem;
	private MenuItem exportTextbookMenuItem;
	private MenuItem exitMenuItem;

	// MenuItems in student menu
	private MenuItem insertStudentMenuItem;
	private MenuItem searchStudentMenuItem;
	private MenuItem removeStudentMenuItem;

	// MenuItems in faculty menu
	private MenuItem insertFacultyMenuItem;
	private MenuItem searchFacultyMenuItem;
	private MenuItem removeFacultyMenuItem;
	// MenuItems in course menu
	private MenuItem insertCourseMenuItem;
	private MenuItem searchCourseMenuItem;
	private MenuItem removeCourseMenuItem;

	// MenuItems in classroom menu
	private MenuItem insertClassroomMenuItem;
	private MenuItem searchClassroomMenuItem;
	private MenuItem removeClassroomMenuItem;

	// MenuItems in textbook menu
	private MenuItem insertTextbookMenuItem;
	private MenuItem searchTextbookMenuItem;
	private MenuItem removeTextbookMenuItem;

	public MenuBarPane() {
		menuBar = new MenuBar();

		buildFileMenu();
		buildStudentMenu();
		buildFacultyMenu();
		buildCourseMenu();
		buildClassroomMenu();
		buildTextbookMenu();

		menuBar.getMenus().addAll(fileMenu, studentMenu, facultyMenu, courseMenu, classroomMenu, textbookMenu);
	}

	public void buildFileMenu() {
		fileMenu = new Menu("File"); 

		saveMenuItem = new MenuItem("Save");
		loadMenuItem = new MenuItem("Load");

		importStudentMenuItem = new MenuItem("Student");
		exportStudentMenuItem = new MenuItem("Student");
		importFacultyMenuItem = new MenuItem("Faculty");
		exportFacultyMenuItem = new MenuItem("Faculty");
		importCourseMenuItem = new MenuItem("Course");
		exportCourseMenuItem = new MenuItem("Course");
		importClassroomMenuItem = new MenuItem("Classroom");
		exportClassroomMenuItem = new MenuItem("Classroom");
		importTextbookMenuItem = new MenuItem("Textbook");
		exportTextbookMenuItem = new MenuItem("Textbook");

		exitMenuItem = new MenuItem("Exit");

		importMenu = new Menu("Import...");
		exportMenu = new Menu("Export...");

		exportMenu.getItems().addAll(exportStudentMenuItem, exportFacultyMenuItem, exportCourseMenuItem,
				exportClassroomMenuItem, exportTextbookMenuItem);

		importMenu.getItems().addAll(importStudentMenuItem, importFacultyMenuItem, importCourseMenuItem,
				importClassroomMenuItem, importTextbookMenuItem);

		fileMenu.getItems().addAll(saveMenuItem, loadMenuItem, new SeparatorMenuItem(), importMenu, exportMenu,
				new SeparatorMenuItem(), exitMenuItem);
	}
 
	public void buildStudentMenu() {
		studentMenu = new Menu("Student");
		insertStudentMenuItem = new MenuItem("Insert");
		searchStudentMenuItem = new MenuItem("Search");
		removeStudentMenuItem = new MenuItem("Remove");

		studentMenu.getItems().addAll(insertStudentMenuItem, searchStudentMenuItem, removeStudentMenuItem);
	}

	public void buildFacultyMenu() {
		facultyMenu = new Menu("Faculty");
		insertFacultyMenuItem = new MenuItem("Insert");
		searchFacultyMenuItem = new MenuItem("Search");
		removeFacultyMenuItem = new MenuItem("Remove");

		facultyMenu.getItems().addAll(insertFacultyMenuItem, searchFacultyMenuItem, removeFacultyMenuItem);
	}

	public void buildCourseMenu() {
		courseMenu = new Menu("Course");
		insertCourseMenuItem = new MenuItem("Insert");
		searchCourseMenuItem = new MenuItem("Search");
		removeCourseMenuItem = new MenuItem("Remove");

		courseMenu.getItems().addAll(insertCourseMenuItem, searchCourseMenuItem, removeCourseMenuItem);
	}

	public void buildClassroomMenu() {
		classroomMenu = new Menu("Classroom");
		insertClassroomMenuItem = new MenuItem("Insert");
		searchClassroomMenuItem = new MenuItem("Search");
		removeClassroomMenuItem = new MenuItem("Remove");

		classroomMenu.getItems().addAll(insertClassroomMenuItem, searchClassroomMenuItem, removeClassroomMenuItem);
	}

	public void buildTextbookMenu() {
		textbookMenu = new Menu("Textbook");
		insertTextbookMenuItem = new MenuItem("Insert");
		searchTextbookMenuItem = new MenuItem("Search");
		removeTextbookMenuItem = new MenuItem("Remove");

		textbookMenu.getItems().addAll(insertTextbookMenuItem, searchTextbookMenuItem, removeTextbookMenuItem);
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public Menu getFacultyMenu() {
		return facultyMenu;
	}

	public MenuItem getSaveMenuItem() {
		return saveMenuItem;
	}

	public MenuItem getLoadMenuItem() {
		return loadMenuItem;
	}

	public MenuItem getImportStudentMenuItem() {
		return importStudentMenuItem;
	}

	public MenuItem getExportStudentMenuItem() {
		return exportStudentMenuItem;
	}

	public MenuItem getImportFacultyMenuItem() {
		return importFacultyMenuItem;
	}

	public MenuItem getExportFacultyMenuItem() {
		return exportFacultyMenuItem;
	}

	public MenuItem getImportCourseMenuItem() {
		return importCourseMenuItem;
	}

	public MenuItem getExportCourseMenuItem() {
		return exportCourseMenuItem;
	}

	public MenuItem getImportClassroomMenuItem() {
		return importClassroomMenuItem;
	}

	public MenuItem getExportClassroomMenuItem() {
		return exportClassroomMenuItem;
	}

	public MenuItem getImportTextbookMenuItem() {
		return importTextbookMenuItem;
	}

	public MenuItem getExportTextbookMenuItem() {
		return exportTextbookMenuItem;
	}

	public MenuItem getExitMenuItem() {
		return exitMenuItem;
	}

	public MenuItem getInsertStudentMenuItem() {
		return insertStudentMenuItem;
	}

	public MenuItem getSearchStudentMenuItem() {
		return searchStudentMenuItem;
	}

	public MenuItem getRemoveStudentMenuItem() {
		return removeStudentMenuItem;
	}


	public MenuItem getInsertFacultyMenuItem() {
		return insertFacultyMenuItem;
	}

	public MenuItem getSearchFacultyMenuItem() {
		return searchFacultyMenuItem;
	}

	public MenuItem getRemoveFacultyMenuItem() {
		return removeFacultyMenuItem;
	}

	

	public MenuItem getInsertCourseMenuItem() {
		return insertCourseMenuItem;
	}

	public MenuItem getSearchCourseMenuItem() {
		return searchCourseMenuItem;
	}

	public MenuItem getRemoveCourseMenuItem() {
		return removeCourseMenuItem;
	}

	

	public MenuItem getInsertClassroomMenuItem() {
		return insertClassroomMenuItem;
	}

	public MenuItem getSearchClassroomMenuItem() {
		return searchClassroomMenuItem;
	}

	public MenuItem getRemoveClassroomMenuItem() {
		return removeClassroomMenuItem;
	}

	

	public MenuItem getInsertTextbookMenuItem() {
		return insertTextbookMenuItem;
	}

	public MenuItem getSearchTextbookMenuItem() {
		return searchTextbookMenuItem;
	}

	public MenuItem getRemoveTextbookMenuItem() {
		return removeTextbookMenuItem;
	}

	

}