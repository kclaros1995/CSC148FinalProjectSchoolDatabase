package View;

import Model.*;
import javafx.application.Platform;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.Scanner;

public class RootPane {
	private BorderPane rootPane;
	private MenuBarPane menuBarPane;
	private MenuBar menuBar;
	private Optional<String> result = null;

	public RootPane() {
		rootPane = new BorderPane();
		menuBarPane = new MenuBarPane();
		menuBar = menuBarPane.getMenuBar();
		rootPane.setTop(menuBar);
		ImageView image;
		try {
			image = new ImageView(new Image(new FileInputStream("H2.png")));
			image.setFitWidth(600);
			image.setFitHeight(320);
			rootPane.setCenter(image);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		buildMenuBarEventHandlers();

	}

	public void buildMenuBarEventHandlers() {
		buildFileMenuEventHandlers();
		buildStudentMenuEventHandlers();
		buildFacultyMenuEventHandlers();
		buildCourseMenuEventHandlers();
		buildClassroomMenuEventHandlers();
		buildTextbookMenuEventHandlers();
	}

	public void buildStudentMenuEventHandlers() {

		menuBarPane.getInsertStudentMenuItem().setOnAction(e -> {
			StudentPane studentPane = new StudentPane();
			Pane studentCenterPane = studentPane.getStudentPane();
			rootPane.setCenter(studentCenterPane);
			studentPane.getButtonBox().getChildren().removeAll();
			studentPane.getButtonBox().getChildren().add(studentPane.getInsertBtn());
			studentPane.getIdField().setDisable(true);
			rootPane.setCenter(studentCenterPane);

		});

		menuBarPane.getSearchStudentMenuItem().setOnAction(e -> {
			TextInputDialog tid = new TextInputDialog();
			tid.setTitle("Search for Student");
			tid.setHeaderText("Enter ID# ");
			tid.setContentText("please enter ID# your want to search");
			result = tid.showAndWait();
			result.ifPresent(response -> {
				College.getPersonBag().findById(response);
				StudentPane studentPane = new StudentPane();
				Pane studentCenterPane = studentPane.getStudentPane();
				studentPane.updateField(response);
				studentPane.getButtonBox().getChildren().removeAll();
				studentPane.getButtonBox().getChildren().add(studentPane.getUpdateBtn());
				studentPane.getButtonBox().getChildren().add(studentPane.getCalculateGpaBtn());
				studentPane.getIdField().setDisable(false);
				rootPane.setCenter(studentCenterPane);
			});

		});

		menuBarPane.getRemoveStudentMenuItem().setOnAction(e -> {
			TextInputDialog tid = new TextInputDialog();
			tid.setTitle("Remove Student");
			tid.setHeaderText("Enter ID #");
			tid.setContentText("Please enter the Id# you want to remove");
			result = tid.showAndWait();

			result.ifPresent(response -> {
				Util.failureAlert("Student Removed");
				College.getPersonBag().removeById(response.toString());
			});

		});

	}

	public void buildFacultyMenuEventHandlers() {

		menuBarPane.getInsertFacultyMenuItem().setOnAction(e -> {
			FacultyPane facultyPane = new FacultyPane();
			Pane facultyCenterPane = facultyPane.getFacultyPane();
			facultyPane.getButtonBox().getChildren().removeAll();
			facultyPane.getButtonBox().getChildren().add(facultyPane.getInsertBtn());
			facultyPane.getIdField().setDisable(true);
			rootPane.setCenter(facultyCenterPane);

		});

		menuBarPane.getSearchFacultyMenuItem().setOnAction(e -> {
			TextInputDialog tid = new TextInputDialog();
			tid.setTitle("Search for Faculty");
			tid.setHeaderText("Enter ID");
			tid.setContentText("Please enter ID# to seach");
			result = tid.showAndWait();
			result.ifPresent(response -> {
				College.getPersonBag().findById(response);
				FacultyPane facultyPane = new FacultyPane();
				Pane facultyPaneCenterPane = facultyPane.getFacultyPane();
				facultyPane.updateField(response);
				facultyPane.getButtonBox().getChildren().removeAll();
				facultyPane.getButtonBox().getChildren().add(facultyPane.getUpdateBtn());
				facultyPane.getIdField().setDisable(false);
				rootPane.setCenter(facultyPaneCenterPane);
			});
		});

		menuBarPane.getRemoveFacultyMenuItem().setOnAction(e -> {
			TextInputDialog tid = new TextInputDialog();
			tid.setTitle("Remove Faculty");
			tid.setHeaderText("Enter ID");
			tid.setContentText("Please enter the ID# you want to remove");
			result = tid.showAndWait();

			result.ifPresent(response -> {
				Util.failureAlert("Faculty Removed");
				College.getPersonBag().removeById(response);
			});

		});

	}

	public void buildCourseMenuEventHandlers() {
		menuBarPane.getInsertCourseMenuItem().setOnAction(e -> {
			CoursePane coursePane = new CoursePane();
			Pane courseCenterPane = coursePane.getCoursePane();
			coursePane.getButtonBox().getChildren().removeAll();
			coursePane.getButtonBox().getChildren().add(coursePane.getInsertBtn());
			rootPane.setCenter(courseCenterPane);

		});

		menuBarPane.getSearchCourseMenuItem().setOnAction(e -> {
			TextInputDialog tid = new TextInputDialog();
			tid.setTitle("Search Course");
			tid.setHeaderText("Enter Course number");
			tid.setContentText("Enter course number you want to search");
			result = tid.showAndWait();
			result.ifPresent(response -> {
				College.getCourseBag().findByCourseNumber(response);
				CoursePane coursePane = new CoursePane();
				Pane courseCenterPane = coursePane.getCoursePane();
				coursePane.updateField(response);
				coursePane.getButtonBox().getChildren().removeAll();
				coursePane.getButtonBox().getChildren().add(coursePane.getUpdateBtn());
				rootPane.setCenter(courseCenterPane);

			});
		});

		menuBarPane.getRemoveCourseMenuItem().setOnAction(e -> {
			TextInputDialog tid = new TextInputDialog();
			tid.setTitle("Remove Course");
			tid.setHeaderText("Enter Course Number");
			tid.setContentText("Please enter the course# you want to remove");
			result = tid.showAndWait(); // caption result and it is a string

			result.ifPresent(response -> {
				Util.failureAlert("Course Removed");
				College.getCourseBag().removeByCourseNumber(response.toString());
			});
		});

	}

	public void buildClassroomMenuEventHandlers() {

		menuBarPane.getInsertClassroomMenuItem().setOnAction(e -> {
			ClassroomPane classroomPane = new ClassroomPane();
			Pane classroomCenterPane = classroomPane.getClassroomPane();
			classroomPane.getButtonBox().getChildren().removeAll();
			classroomPane.getButtonBox().getChildren().add(classroomPane.getInsertBtn());
			rootPane.setCenter(classroomCenterPane);
		});

		menuBarPane.getSearchClassroomMenuItem().setOnAction(e -> {
			TextInputDialog tid = new TextInputDialog();
			tid.setTitle("Search Classroom");
			tid.setHeaderText("Search room#");
			tid.setContentText("please enter classroom number you want to search");
			result = tid.showAndWait();
			result.ifPresent(response -> {
				;
				College.getClassroomBag().findByClassroomNumber(response);
				ClassroomPane classroomPane = new ClassroomPane();
				Pane classroomCenterPane = classroomPane.getClassroomPane();
				classroomPane.getButtonBox().getChildren().removeAll();
				classroomPane.getButtonBox().getChildren().add(classroomPane.getUpdateBtn());
				classroomPane.updateField(response);
				rootPane.setCenter(classroomCenterPane);

			});
		});

		menuBarPane.getRemoveClassroomMenuItem().setOnAction(e -> {
			TextInputDialog tid = new TextInputDialog();
			tid.setTitle("Remove Classroom");
			tid.setHeaderText("Enter Room #");
			tid.setContentText("Please enter the room number you want to remove");
			result = tid.showAndWait();
			result.ifPresent(response -> {
				Util.failureAlert("Classroom Removed");
				College.getClassroomBag().removeByClassroomNumber(response.toString());
			});
		});

	}

	public void buildTextbookMenuEventHandlers() {

		menuBarPane.getInsertTextbookMenuItem().setOnAction(e -> {
			TextbookPane textbookPane = new TextbookPane();
			Pane textbookCenterPane = textbookPane.getTextbookPane();
			textbookPane.getButtonBox().getChildren().removeAll();
			textbookPane.getButtonBox().getChildren().add(textbookPane.getInsertBtn());
			rootPane.setCenter(textbookCenterPane);
		});

		menuBarPane.getSearchTextbookMenuItem().setOnAction(e -> {
			TextInputDialog tid = new TextInputDialog();
			tid.setTitle("Search Textbook");
			tid.setHeaderText("Enter ISBN");
			tid.setContentText("Enter isbn for textook desired to search");
			result = tid.showAndWait();
			result.ifPresent(response -> {
				;
				College.getTextbookBag().findByIsbn(response);
				TextbookPane textbookPane = new TextbookPane();
				Pane textbookCenterPane = textbookPane.getTextbookPane();
				textbookPane.getButtonBox().getChildren().removeAll();
				textbookPane.getButtonBox().getChildren().add(textbookPane.getUpdateBtn());
				textbookPane.updateField(response);
				rootPane.setCenter(textbookCenterPane);
			});
		});

		menuBarPane.getRemoveTextbookMenuItem().setOnAction(e -> {

			TextInputDialog tid = new TextInputDialog();
			tid.setTitle("Remove Textroom");
			tid.setHeaderText("Enter ISBN. #");
			tid.setContentText("Please enter the ISBN# you want to remove");
			result = tid.showAndWait();

			result.ifPresent(response -> {
				Util.failureAlert("Textbook Removed");
				College.getTextbookBag().removeByIsbn(response.toString());
			});
		});

	}

	public void buildFileMenuEventHandlers() {
		buildExitMenuItemHandler();
		buildSaveMenuItemHandler();
		buildLoadMenuItemHandler();
		buildImportStudentMenuItemHandler();
		buildExportStudentMenuItemHandler();
		buildImportFacultyMenuItemHandler();
		buildExportFacultyMenuItemHandler();
		buildImportCourseMenuItemHandler();
		buildExportCourseMenuItemHandler();
		buildImportClassroomMenuItemHandler();
		buildExportClassroomMenuItemHandler();
		buildImportTextbookMenuItemHandler();
		buildExportTextbookMenuItemHandler();
	}

	public Pane getRootPane() {
		return rootPane;
	}

	public void buildExitMenuItemHandler() {
		menuBarPane.getExitMenuItem().setOnAction(e -> {
			College.saveAll();
			Platform.exit();
			System.exit(0);
		});
	}

	public void buildSaveMenuItemHandler() {
		menuBarPane.getSaveMenuItem().setOnAction(e -> {
			College.saveAll();
		});
	}

	public void buildLoadMenuItemHandler() {
		menuBarPane.getLoadMenuItem().setOnAction(e -> {
			College.loadAll();
		});
	}

	public void buildImportStudentMenuItemHandler() {
		menuBarPane.getImportStudentMenuItem().setOnAction(e -> {
			File file = new File("Import/Student.txt");
			try {
				Scanner input = new Scanner(file);
				while (input.hasNextLine()) {
					Student s = new Student();
					String[] name = input.nextLine().split(" ");
					String[] address = input.nextLine().split("[,]? ");
					String phone = input.nextLine();
					String major = input.nextLine();
					String[] coursesTook = input.nextLine().split(",");
					String[] grades1Text = input.nextLine().split(",");
					Grade[] grades1 = new Grade[grades1Text.length];
					for (int i = 0; i < grades1Text.length; i++) {
						Grade grade = new Grade(coursesTook[i], grades1Text[i]);
						grades1[i] = grade;
					}

					String[] coursesTaking = input.nextLine().split(",");
					Grade[] grades2 = new Grade[coursesTaking.length];
					for (int i = 0; i < coursesTaking.length; i++) {
						Grade grade2 = new Grade(coursesTaking[i]);
						grades2[i] = grade2;
					}

					String[] coursesToTake = input.nextLine().split(",");
					Grade[] grades3 = new Grade[coursesToTake.length];
					for (int i = 0; i < coursesToTake.length; i++) {
						Grade grade3 = new Grade(coursesToTake[i]);
						grades3[i] = grade3;
					}
					s.setName(new Name(name[0], name[1]));
					s.setAddress(
							new Address(address[0], address[1] + " " + address[2], address[3], address[4], address[5]));
					s.setPhone(phone);
					s.setMajor(major);
					s.setCoursesTook(grades1);
					s.setCoursesTaking(grades2);
					s.setCoursesToTake(grades3);
					College.getPersonBag().insert(s);
				}
				input.close();

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

		});
	}

	public void buildExportStudentMenuItemHandler() {
		menuBarPane.getExportStudentMenuItem().setOnAction(e -> {
			Stage stage = new Stage();
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showSaveDialog(stage);
			if (file != null) {

				PrintWriter pw = null;
				try {
					pw = new PrintWriter(file);
				} catch (FileNotFoundException es) {
					Model.Util.failureAlert("Failure exporting Person data!");
				}
				for (int i = 0; i < PersonBag.getnElems(); i++) {
					Person person = PersonBag.getPersonArray()[i];
					if (person instanceof Student) {
						pw.println(person.toString());
					}
				}
				pw.close();
			}
		});
	}

	public void buildImportFacultyMenuItemHandler() {
		menuBarPane.getImportFacultyMenuItem().setOnAction(e -> {
			File file = new File("import/Faculty.txt");
			try {
				Scanner input = new Scanner(file);
				while (input.hasNextLine()) {
					Faculty faculty = new Faculty();
					String[] tokens = input.nextLine().split(" ");
					String phone = input.nextLine();
					String[] tokens2 = input.nextLine().split("[,]? ");
					double salary = Double.valueOf(input.nextLine());
					String title = input.nextLine();
					String officeAddress = input.nextLine();
					faculty.setName(new Name(tokens[0], tokens[1]));
					faculty.setPhone(phone);
					faculty.setAddress(new Address(tokens2[0], tokens2[1] + "  " + tokens2[2], tokens2[3], tokens2[4],
							tokens2[5]));
					faculty.setSalary(salary);
					faculty.setTitle(title);
					faculty.setOfficeAddress(officeAddress);
					College.getPersonBag().insert(faculty);
				}
				input.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
	}

	public void buildExportFacultyMenuItemHandler() {
		menuBarPane.getExportFacultyMenuItem().setOnAction(e -> {
			Stage stage = new Stage();
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showSaveDialog(stage);
			if (file != null) {

				PrintWriter pw = null;
				try {
					pw = new PrintWriter(file);
				} catch (FileNotFoundException ez) {
					Model.Util.failureAlert("Failure exporting Person data!");
				}
				for (int i = 0; i < PersonBag.getnElems(); i++) {
					Person person = PersonBag.getPersonArray()[i];
					if (person instanceof Faculty) {
						pw.println(person.toString());
					}
				}
				pw.close();
			}
		});
	}

	public void buildImportCourseMenuItemHandler() {
		menuBarPane.getImportCourseMenuItem().setOnAction(e -> {
			File file = new File("import/Course.txt");
			try {
				Scanner input = new Scanner(file);
				while (input.hasNextLine()) {
					String courseTitle = input.nextLine();
					String courseNumber = input.nextLine();
					int numberOfCredits = Integer.valueOf(input.nextLine());
					String courseDescription = input.nextLine();
					String facultyId = input.nextLine();
					Course course = new Course(courseTitle, courseNumber, numberOfCredits, courseDescription,
							facultyId);
					College.getCourseBag().insert(course);
				}
				input.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
	}

	public void buildExportCourseMenuItemHandler() {
		menuBarPane.getExportCourseMenuItem().setOnAction(e -> {

			Stage stage = new Stage();
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showSaveDialog(stage);
			if (file != null) {

				PrintWriter pw = null;
				try {
					pw = new PrintWriter(file);
				} catch (FileNotFoundException ez) {
					Model.Util.failureAlert("Failure exporting Course data!");
				}
				for (int i = 0; i < CourseBag.getnElems(); i++) {
					Course course = CourseBag.getCourseArray()[i];
					pw.println(course.toString());
				}
				pw.close();
			}

		});
	}

	public void buildImportClassroomMenuItemHandler() {
		menuBarPane.getImportClassroomMenuItem().setOnAction(e -> {
			File file = new File("import/Classroom.txt");
			try {
				Scanner input = new Scanner(file);
				while (input.hasNextLine()) {
					String roomNumber = input.nextLine();
					Classroom classroom = new Classroom(roomNumber, Integer.valueOf(input.nextLine()),
							Boolean.valueOf(input.nextLine()));
					College.getClassroomBag().insert(classroom);
				}
				input.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
	}

	public void buildExportClassroomMenuItemHandler() {
		menuBarPane.getExportClassroomMenuItem().setOnAction(e -> {
			Stage stage = new Stage();
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showSaveDialog(stage);
			if (file != null) {

				PrintWriter pw = null;
				try {
					pw = new PrintWriter(file);
				} catch (FileNotFoundException ez) {
					Model.Util.failureAlert("Failure exporting Student data!");
				}
				for (int i = 0; i < ClassroomBag.getnElems(); i++) {
					Classroom classroom = ClassroomBag.getClassroomArray()[i];
					pw.println(classroom.toString());
				}
				pw.close();
			}
		});
	}

	public void buildImportTextbookMenuItemHandler() {
		menuBarPane.getImportTextbookMenuItem().setOnAction(e -> {
			File file = new File("import/Textbook.txt");
			try {
				Scanner scanner = new Scanner(file);
				while (scanner.hasNextLine()) {
					String title = scanner.nextLine();
					String[] tokens = scanner.nextLine().split(" ");
					Name author = new Name(tokens[0], tokens[1]);
					String publisher = scanner.nextLine();
					String isbn = scanner.nextLine();
					Textbook textbook = new Textbook(title, author, publisher, isbn,
							Double.valueOf(scanner.nextLine()));
					College.getTextbookBag().insert(textbook);
				}
				scanner.close();
			} catch (FileNotFoundException a) {
				a.printStackTrace();
			}

		});
	}

	public void buildExportTextbookMenuItemHandler() {
		menuBarPane.getExportTextbookMenuItem().setOnAction(e -> {
			Stage stage = new Stage();
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showSaveDialog(stage);
			if (file != null) {

				PrintWriter pw = null;
				try {
					pw = new PrintWriter(file);
				} catch (FileNotFoundException ez) {
					Model.Util.failureAlert("Failure exporting textbook data!");
				}
				for (int i = 0; i < TextbookBag.getnElems(); i++) {
					Textbook textbook = TextbookBag.getTextbookArray()[i];
					pw.println(textbook.toString());
				}
				pw.close();
			}
		});
	}

}