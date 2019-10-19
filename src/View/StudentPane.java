package View;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Arrays;

public class StudentPane {
	private GridPane studentPane;

	private TextField firstNameField;
	private TextField middleInitialField;
	private TextField lastNameField;
	private TextField streetNumberField;
	private TextField streetNameField;
	private TextField cityField;
	private ComboBox<String> stateList;
	private TextField zipField;
	private TextField idField;
	private TextField gpaField;
	private ComboBox<String> majorList;
	private TextField phoneField;
	private TextField coursesTookField;
	private TextField coursesTakingField;
	private TextField coursesToTakeField;
	private ComboBox<String> letterGradeList;
	private ComboBox<String> courseListComboBOx;

	private HBox buttonBox;
	private Button insertBtn;
	private Button searchBtn;
	private Button updateBtn;
	private Button calculateGpaBtn;

	private VBox buttonBox2;
	private Button addBtn1;
	private Button addBtn2;
	private Button addBtn3;

	private final int TEXTFIELD_WIDTH_SHORT = 50;
	private final int TEXTFIELD_WIDTH_LONG = 200;
	private final int TEXTFIELD_WIDTH_MEDIUM = 150;
	private final int BUTTON_WIDTH = 110;
	private final int HGAP = 10;
	private final int VGAP = 20;
	private final int INSETS_VALUE = 50;

	public StudentPane() {
		studentPane = new GridPane();
		studentPane.setGridLinesVisible(false);
		studentPane.setHgap(HGAP);
		studentPane.setVgap(VGAP);
		studentPane.setPadding(new Insets(INSETS_VALUE));

		firstNameField = new TextField();
		firstNameField.setPromptText("First Name");
		firstNameField.setPrefWidth(TEXTFIELD_WIDTH_MEDIUM);

		middleInitialField = new TextField();
		middleInitialField.setPromptText("Middle Initial");
		middleInitialField.setPrefWidth(TEXTFIELD_WIDTH_SHORT);

		lastNameField = new TextField();
		lastNameField.setPromptText("Last Name");
		lastNameField.setPrefWidth(TEXTFIELD_WIDTH_MEDIUM);

		streetNumberField = new TextField();
		streetNumberField.setPromptText("Street Number");
		streetNumberField.setPrefWidth(TEXTFIELD_WIDTH_SHORT);

		streetNameField = new TextField();
		streetNameField.setPromptText("Street Name");
		streetNameField.setPrefWidth(TEXTFIELD_WIDTH_LONG);

		cityField = new TextField();
		cityField.setPromptText("City");
		cityField.setPrefWidth(TEXTFIELD_WIDTH_MEDIUM);

		stateList = new ComboBox<>();
		stateList.setPromptText("State");
		stateList.setPrefWidth(TEXTFIELD_WIDTH_MEDIUM);
		States states = new States();
		stateList.getItems().addAll(states.getStates());

		zipField = new TextField();
		zipField.setPromptText("Zip");
		zipField.setPrefWidth(TEXTFIELD_WIDTH_SHORT);

		idField = new TextField();
		idField.setPromptText("ID");
		idField.setPrefWidth(TEXTFIELD_WIDTH_MEDIUM);

		gpaField = new TextField();
		gpaField.setPromptText("GPA");
		gpaField.setPrefWidth(TEXTFIELD_WIDTH_MEDIUM);

		ObservableList<String> list = FXCollections.observableArrayList();
		list.add("Computer Science");
		list.add("Mathematics");
		list.add("English");
		list.add("Biology");
		list.add("Chemistry");
		list.add("History");
		list.add("Information Tethnology");
		majorList = new ComboBox<String>(list);
		majorList.setPromptText("Major");
		majorList.setPrefWidth(TEXTFIELD_WIDTH_MEDIUM);

		ObservableList<String> gradeList = FXCollections.observableArrayList();
		gradeList.add("A");
		gradeList.add("B+");
		gradeList.add("B");
		gradeList.add("C+");
		gradeList.add("C");
		gradeList.add("D+");
		gradeList.add("D");
		gradeList.add("F");
		letterGradeList = new ComboBox<String>(gradeList);
		letterGradeList.setPromptText("Grade");
		letterGradeList.setPrefWidth(110);

		ObservableList<String> coursesList = FXCollections.observableArrayList();
		coursesList.add("MAT001");
		coursesList.add("MAT100");
		coursesList.add("MAT111");
		coursesList.add("MAT112");
		coursesList.add("MAT141");
		coursesList.add("MAT142");
		coursesList.add("MAT205");
		coursesList.add("MAT210");
		coursesList.add("ENG101");
		coursesList.add("ENG150");
		coursesList.add("ENG200");
		coursesList.add("PHY101");
		coursesList.add("PHY130");
		coursesList.add("PHY150");
		coursesList.add("PHY152");
		coursesList.add("CHEM101");
		coursesList.add("CHEM133");
		coursesList.add("CHEM134");
		coursesList.add("LIT101");
		coursesList.add("LIT150");
		coursesList.add("HIS101");
		coursesList.add("CSE110");
		coursesList.add("CSE118");
		coursesList.add("CSE148");
		coursesList.add("CSE205");
		coursesList.add("CSE210");
		courseListComboBOx = new ComboBox<String>(coursesList);
		courseListComboBOx.setPromptText("Course");
		courseListComboBOx.setPrefWidth(TEXTFIELD_WIDTH_MEDIUM);

		phoneField = new TextField();
		phoneField.setPromptText("Phone");
		phoneField.setPrefWidth(TEXTFIELD_WIDTH_MEDIUM);

		coursesTookField = new TextField();
		coursesTookField.setPromptText("Courses Took");
		coursesTookField.setPrefWidth(TEXTFIELD_WIDTH_LONG);

		coursesTakingField = new TextField();
		coursesTakingField.setPromptText("Courses Taking");
		coursesTakingField.setPrefWidth(TEXTFIELD_WIDTH_LONG);

		coursesToTakeField = new TextField();
		coursesToTakeField.setPromptText("Courses To Take");
		coursesToTakeField.setPrefWidth(TEXTFIELD_WIDTH_LONG);

		addBtn1 = new Button("ADD");
		addBtn1.setPrefWidth(BUTTON_WIDTH);

		addBtn2 = new Button("ADD");
		addBtn2.setPrefWidth(BUTTON_WIDTH);

		addBtn3 = new Button("ADD");
		addBtn3.setPrefWidth(BUTTON_WIDTH);

		int i = 0;
		int j = 0;
		studentPane.add(firstNameField, i, j, 4, 1);
		studentPane.add(middleInitialField, i + 4, j, 3, 1);
		studentPane.add(lastNameField, i + 4 + 3, j, 3, 1);
		studentPane.add(phoneField, i, j + 4, 8, 1);
		studentPane.add(idField, i + 8, j + 4, 2, 1);
		studentPane.add(coursesTookField, i + 16, j, 9, 1);
		studentPane.add(letterGradeList, i + 10, j, 6, 1);
		studentPane.add(courseListComboBOx, i + 35, j, 12, 1);
		studentPane.add(addBtn1, i + 25, j, 8, 1);

		j += 2;
		studentPane.add(streetNumberField, i, j, 4, 1);
		studentPane.add(streetNameField, i + 4, j, 5, 1);
		studentPane.add(coursesTakingField, i + 16, j, 9, 1);
		studentPane.add(addBtn2, i + 25, j, 8, 1);

		j++;
		studentPane.add(cityField, i, j, 6, 1);
		studentPane.add(stateList, i + 6, j, 7, 1);
		studentPane.add(zipField, i + 12, j, 5, 1);
		studentPane.add(coursesToTakeField, i + 16, j, 9, 2);
		studentPane.add(addBtn3, i + 25, j, 8, 2);

		j += 2;

		studentPane.add(gpaField, 0, j, 4, 1);

		studentPane.add(majorList, 4, j, 6, 1);

		j += 4;
		buttonBox = new HBox(20);
		insertBtn = new Button("INSERT");
		insertBtn.setPrefWidth(BUTTON_WIDTH);
		searchBtn = new Button("SEARCH");
		searchBtn.setPrefWidth(BUTTON_WIDTH);
		updateBtn = new Button("UPDATE");
		updateBtn.setPrefWidth(BUTTON_WIDTH);
		calculateGpaBtn = new Button("GPA");
		calculateGpaBtn.setPrefWidth(BUTTON_WIDTH);

		buttonBox.setAlignment(Pos.CENTER);
		studentPane.add(buttonBox, 8, j, 10, 1);

		addBtn1.setOnAction(e -> {
			String cTookCourseNumber = courseListComboBOx.getSelectionModel().getSelectedItem();
			String cTookLetterGrade = letterGradeList.getSelectionModel().getSelectedItem();
			Grade[] coursesTook = { new Grade(cTookCourseNumber, cTookLetterGrade) };
			coursesTookField.appendText(Arrays.toString(coursesTook));
		});

		addBtn2.setOnAction(e -> {
			String cTakingCourseNumber = courseListComboBOx.getSelectionModel().getSelectedItem();
			Grade[] coursesTaking = { new Grade(cTakingCourseNumber) };
			coursesTakingField.appendText(Arrays.toString(coursesTaking));
		});

		addBtn3.setOnAction(e -> {
			String cToTakeCourseNumber = courseListComboBOx.getSelectionModel().getSelectedItem();
			Grade[] coursesToTake = { new Grade(cToTakeCourseNumber) };
			coursesToTakeField.appendText(Arrays.toString(coursesToTake));
		});

		insertBtn.setOnAction(e -> {
			Student s = new Student();
			if (middleInitialField.getText().length() > 0) {

				s.setName(firstNameField.getText(), middleInitialField.getText().charAt(0), lastNameField.getText());
			} else {
				s.setName(new Name(firstNameField.getText(),  lastNameField.getText()));
				
			}
			s.setAddress(streetNumberField.getText(), streetNameField.getText(), cityField.getText(),
					stateList.getSelectionModel().getSelectedItem(), zipField.getText());
			s.setMajor(majorList.getSelectionModel().getSelectedItem());
			s.setPhone(phoneField.getText());
			String courseNumber = coursesTookField.getText();
			String letterGrade = coursesTookField.getText();
			Grade[] coursesTook = { new Grade(courseNumber, letterGrade) };
			s.setCoursesTook(coursesTook);
			String courseNumber2 = coursesTakingField.getText();
			Grade[] coursesTaking = { new Grade(courseNumber2) };
			s.setCoursesTaking(coursesTaking);
			String courseNumber3 = coursesToTakeField.getText();
			Grade[] coursesToTake = { new Grade(courseNumber3) };
			s.setCoursesToTake(coursesToTake);
			College.getPersonBag().insert(s);
			coursesTookField.clear();
			coursesTakingField.clear();
			coursesToTakeField.clear();
			firstNameField.clear();
			middleInitialField.clear();
			lastNameField.clear();
			stateList.setPromptText("states");
			streetNumberField.clear();
			streetNameField.clear();
			cityField.clear();
			zipField.clear();
			phoneField.clear();
			majorList.setPromptText("Major");

		});

		updateBtn.setOnAction(e -> {
			;
			Student s = (Student) College.getPersonBag().findById(idField.getText());
			if (s == null) {
				Model.Util.failureAlert("error finding student");
				return;
			}
			s.setName(firstNameField.getText(), middleInitialField.getText().charAt(0), lastNameField.getText());
			s.setAddress(streetNumberField.getText(), streetNameField.getText(), cityField.getText(),
					stateList.getSelectionModel().getSelectedItem(), zipField.getText());
			s.setMajor(majorList.getSelectionModel().getSelectedItem());
			s.setPhone(phoneField.getText());
			String courseNumber = coursesTookField.getText();
			String letterGrade = coursesTookField.getText();
			Grade[] coursesTook = { new Grade(courseNumber, letterGrade) };
			s.setCoursesTook(coursesTook);
			String courseNumber2 = coursesTakingField.getText();
			Grade[] coursesTaking = { new Grade(courseNumber2) };
			s.setCoursesTaking(coursesTaking);
			String courseNumber3 = coursesToTakeField.getText();
			Grade[] coursesToTake = { new Grade(courseNumber3) };
			s.setCoursesToTake(coursesToTake);

		});

		calculateGpaBtn.setOnAction(e -> {
			Student s = (Student) College.getPersonBag().findById(idField.getText());
			CreditsAndGpaCalculator gpaC = new CreditsAndGpaCalculator();
			double gpa = gpaC.calculateGPA(s.getCoursesTook(), College.getCourseBag());
			gpaField.setText(String.valueOf(gpa));
		});
	}

	public void updateField(String id) {
		Person search = College.getPersonBag().findById(id);
		if (search == null) {
			Model.Util.failureAlert("trouble finding specific student");
			return;
		}

		streetNumberField.setText(((Student) College.getPersonBag().findById(id)).getAddress().getStreetNumber());
		streetNameField.setText(((Student) College.getPersonBag().findById(id)).getAddress().getStreetName());
		cityField.setText(((Student) College.getPersonBag().findById(id)).getAddress().getCity());
		zipField.setText(((Student) College.getPersonBag().findById(id)).getAddress().getZip());
		firstNameField.setText(((Student) College.getPersonBag().findById(id)).getName().getfName());
		middleInitialField
				.setText(String.valueOf((((Student) College.getPersonBag().findById(id)).getName().getmInitial())));
		stateList.getSelectionModel().select(((Student) College.getPersonBag().findById(id)).getAddress().getState());
		majorList.getSelectionModel().select(((Student) College.getPersonBag().findById(id)).getMajor());
		lastNameField.setText(((Student) College.getPersonBag().findById(id)).getName().getlName());
		phoneField.setText(((Student) College.getPersonBag().findById(id)).getPhone());
		coursesTookField.setText(Arrays.toString((((Student) College.getPersonBag().findById(id)).getCoursesTook())));
		coursesTakingField
				.setText(Arrays.toString((((Student) College.getPersonBag().findById(id)).getCoursesTaking())));
		coursesToTakeField
				.setText(Arrays.toString((((Student) College.getPersonBag().findById(id)).getCoursesToTake())));
		idField.setText(id);
	}

	public void setAddBtn1(Button addBtn1) {
		this.addBtn1 = addBtn1;
	}

	public VBox getButtonBox2() {
		return buttonBox2;
	}

	public void setButtonBox2(VBox buttonBox2) {
		this.buttonBox2 = buttonBox2;
	}

	public Button getAddBtn2() {
		return addBtn2;
	}

	public void setAddBtn2(Button addBtn2) {
		this.addBtn2 = addBtn2;
	}

	public Button getAddBtn3() {
		return addBtn3;
	}

	public void setAddBtn3(Button addBtn3) {
		this.addBtn3 = addBtn3;
	}

	public GridPane getStudentPane() {
		return studentPane;
	}

	public ComboBox<String> getMajorList() {
		return majorList;
	}

	public void setMajorList(ComboBox<String> majorList) {
		this.majorList = majorList;
	}

	public TextField getCoursesTookField() {
		return coursesTookField;
	}

	public void setCoursesTookField(TextField coursesTookField) {
		this.coursesTookField = coursesTookField;
	}

	public TextField getCoursesTakingField() {
		return coursesTakingField;
	}

	public void setCoursesTakingField(TextField coursesTakingField) {
		this.coursesTakingField = coursesTakingField;
	}

	public TextField getCoursesToTakeField() {
		return coursesToTakeField;
	}

	public void setCoursesToTakeField(TextField coursesToTakeField) {
		this.coursesToTakeField = coursesToTakeField;
	}

	public void setStudentPane(GridPane studentPane) {
		this.studentPane = studentPane;
	}

	public TextField getFirstNameField() {
		return firstNameField;
	}

	public void setFirstNameField(TextField firstNameField) {
		this.firstNameField = firstNameField;
	}

	public TextField getMiddleInitialField() {
		return middleInitialField;
	}

	public void setMiddleInitialField(TextField middleInitialField) {
		this.middleInitialField = middleInitialField;
	}

	public TextField getLastNameField() {
		return lastNameField;
	}

	public void setLastNameField(TextField lastNameField) {
		this.lastNameField = lastNameField;
	}

	public TextField getStreetNumberField() {
		return streetNumberField;
	}

	public void setStreetNumberField(TextField streetNumberField) {
		this.streetNumberField = streetNumberField;
	}

	public TextField getStreetNameField() {
		return streetNameField;
	}

	public void setStreetNameField(TextField streetNameField) {
		this.streetNameField = streetNameField;
	}

	public TextField getCityField() {
		return cityField;
	}

	public void setCityField(TextField cityField) {
		this.cityField = cityField;
	}

	public Button getCalculateGpaBtn() {
		return calculateGpaBtn;
	}

	public void setCalculateGpaBtn(Button calculateGpaBtn) {
		this.calculateGpaBtn = calculateGpaBtn;
	}

	public ComboBox<String> getStateList() {
		return stateList;
	}

	public void setStateList(ComboBox<String> stateList) {
		this.stateList = stateList;
	}

	public TextField getZipField() {
		return zipField;
	}

	public void setZipField(TextField zipField) {
		this.zipField = zipField;
	}

	public TextField getIdField() {
		return idField;
	}

	public void setIdField(TextField idField) {
		this.idField = idField;
	}

	public TextField getGpaField() {
		return gpaField;
	}

	public void setGpaField(TextField gpaField) {
		this.gpaField = gpaField;
	}

	public Button getInsertBtn() {
		return insertBtn;
	}

	public void setInsertBtn(Button insertBtn) {
		this.insertBtn = insertBtn;
	}

	public Button getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(Button searchBtn) {
		this.setSearchBtn(searchBtn);
	}

	public Button getUpdateBtn() {
		return updateBtn;
	}

	public void setUpdateBtn(Button updateBtn) {
		this.updateBtn = updateBtn;
	}

	public HBox getButtonBox() {
		return buttonBox;
	}

	public void setButtonBox(HBox buttonBox) {
		this.buttonBox = buttonBox;
	}
}
