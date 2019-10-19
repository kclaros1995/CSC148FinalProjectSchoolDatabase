package View;

import Model.College;
import Model.Faculty;
import Model.Person;
import Model.States;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class FacultyPane {
	private GridPane FacultyPane;

	private TextField firstNameField;
	private TextField middleInitialField;
	private TextField lastNameField;
	private TextField streetNumberField;
	private TextField streetNameField;
	private TextField cityField;
	private ComboBox<String> stateList;
	private TextField zipField;
	private ComboBox<String> tileList; 
	private TextField salaryField;
	private TextField officeAddressField;
	private TextField phoneNumberField;
	private TextField idField;  

	private HBox buttonBox;
	private Button insertBtn;
	private Button searchBtn;
	private Button removeBtn;
	private Button updateBtn;
 
	private final int TEXTFIELD_WIDTH_SHORT = 50;
	private final int TEXTFIELD_WIDTH_LONG = 200;
	private final int TEXTFIELD_WIDTH_MEDIUM = 150;
	private final int BUTTON_WIDTH = 110;
	private final int HGAP = 10; 
	private final int VGAP = 20;
	private final int INSETS_VALUE = 50;

	public FacultyPane() {
		FacultyPane = new GridPane();
		FacultyPane.setGridLinesVisible(false);
		FacultyPane.setHgap(HGAP);
		FacultyPane.setVgap(VGAP);
		FacultyPane.setPadding(new Insets(INSETS_VALUE));

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
		zipField.setPrefWidth(TEXTFIELD_WIDTH_MEDIUM);

		ObservableList<String> list = FXCollections.observableArrayList();
		list.add("Instructor");
		list.add("Assistant professor");
		list.add("Chair");
		list.add("Associate Professor");
		list.add("Adjunct professor");
		list.add("Super Intendant");
		tileList = new ComboBox<>();
		tileList.setPromptText("Title");
		tileList.setPrefWidth(TEXTFIELD_WIDTH_MEDIUM);
		tileList.getItems().addAll(list);

		salaryField = new TextField();
		salaryField.setPromptText("Salary");
		salaryField.setPrefWidth(TEXTFIELD_WIDTH_MEDIUM);
		
		officeAddressField = new TextField();
		officeAddressField.setPromptText("Office Adress");
		officeAddressField.setPrefWidth(TEXTFIELD_WIDTH_LONG);
		
		phoneNumberField = new TextField();
		phoneNumberField.setPromptText("Phone Number");
		phoneNumberField.setPrefWidth(TEXTFIELD_WIDTH_LONG);
		
		idField = new TextField();
		idField.setPromptText("ID");
		idField.setPrefWidth(TEXTFIELD_WIDTH_SHORT);


		

		int i = 0;
		int j = 0;
		FacultyPane.add(firstNameField, i, j, 4, 1);
		FacultyPane.add(middleInitialField, i + 4, j, 3, 1);
		FacultyPane.add(lastNameField, i + 4 + 3, j, 4, 1);
		FacultyPane.add(phoneNumberField, i + 11, j, 5, 1);

		j += 2;
		FacultyPane.add(streetNumberField, i, j, 4, 1);
		FacultyPane.add(streetNameField, i + 4, j, 4, 1);
		FacultyPane.add(idField, i + 8, j, 4, 1);

		j++;
		FacultyPane.add(cityField, i, j, 6, 1);
		FacultyPane.add(stateList, i + 6, j, 3, 1);
		FacultyPane.add(zipField, i + 6 + 3, j, 3, 1);

		j += 2;
		FacultyPane.add(tileList, i, j, 4, 1);

		FacultyPane.add(salaryField, 4, j, 4, 1);
		
		FacultyPane.add(officeAddressField, 8, j, 4, 1);
		
		j += 4;
		buttonBox = new HBox(20);
		insertBtn = new Button("INSERT");
		insertBtn.setPrefWidth(BUTTON_WIDTH);
		searchBtn = new Button("SEARCH");
		searchBtn.setPrefWidth(BUTTON_WIDTH);
		removeBtn = new Button("REMOVE");
		removeBtn.setPrefWidth(BUTTON_WIDTH);
		updateBtn = new Button("UPDATE");
		updateBtn.setPrefWidth(BUTTON_WIDTH);

		buttonBox.setAlignment(Pos.CENTER);
		FacultyPane.add(buttonBox, 0, j, 10, 1);
		
		insertBtn.setOnAction(e->{
			Faculty f = new Faculty();
			f.setAddress(streetNumberField.getText(), streetNameField.getText(), cityField.getText(), stateList.getSelectionModel().getSelectedItem(), zipField.getText());
			f.setName(firstNameField.getText(), middleInitialField.getText().charAt(0), lastNameField.getText());
			f.setOfficeAddress(officeAddressField.getText());
			f.setPhone(phoneNumberField.getText());
			f.setSalary(Double.parseDouble(salaryField.getText()));
			f.setTitle(tileList.getSelectionModel().getSelectedItem());
			College.getPersonBag().insert(f);
			streetNumberField.clear();
		    streetNameField.clear();
		    cityField.clear();
		    zipField.clear();
		    firstNameField.clear();
		    middleInitialField.clear();
		    lastNameField.clear();
		    officeAddressField.clear();
		    phoneNumberField.clear();
		    salaryField.clear();
		    stateList.setPromptText("States");
			tileList.setPromptText("Faculty");

			
		});
		
		updateBtn.setOnAction(e ->{;
		Faculty f =  (Faculty) College.getPersonBag().findById(idField.getText());
		if(f == null) {
			Model.Util.failureAlert("trouble finding  faculty" );
			return;
		}
		f.setAddress(streetNumberField.getText(), streetNameField.getText(), cityField.getText(), stateList.getSelectionModel().getSelectedItem(), zipField.getText());
		f.setName(firstNameField.getText(), middleInitialField.getText().charAt(0), lastNameField.getText());
		f.setOfficeAddress(officeAddressField.getText());
		f.setPhone(phoneNumberField.getText());
		f.setSalary(Double.parseDouble(salaryField.getText()));
		f.setTitle(tileList.getSelectionModel().getSelectedItem());
		});
	}
	public void updateField(String id) {
		
		Person search = College.getPersonBag().findById(id);
		if(search == null) {
			Model.Util.failureAlert("trouble finding specific faculty" );
			return;
		}
		streetNumberField.setText(((Faculty) College.getPersonBag().findById(id)).getAddress().getStreetNumber()) ;
		streetNameField.setText(((Faculty) College.getPersonBag().findById(id)).getAddress().getStreetName());
		cityField.setText(((Faculty) College.getPersonBag().findById(id)).getAddress().getCity());
		zipField.setText(((Faculty) College.getPersonBag().findById(id)).getAddress().getZip());
		firstNameField.setText(((Faculty) College.getPersonBag().findById(id)).getName().getfName());
		middleInitialField.setText(String.valueOf((((Faculty) College.getPersonBag().findById(id)).getName().getmInitial())));
		stateList.getSelectionModel().select((((Faculty) College.getPersonBag().findById(id)).getAddress().getState()));
		lastNameField.setText(((Faculty) College.getPersonBag().findById(id)).getName().getlName());
		officeAddressField.setText(((Faculty) College.getPersonBag().findById(id)).getOfficeAddress());
		phoneNumberField.setText(((Faculty) College.getPersonBag().findById(id)).getPhone());
		salaryField.setText(String.valueOf(((Faculty) College.getPersonBag().findById(id)).getSalary()));
		tileList.getSelectionModel().select(((Faculty) College.getPersonBag().findById(id)).getTitle());
		idField.setText(id);
	}

	public GridPane getFacultyPane() {
		return FacultyPane;
	}

	public void setFacultyPane(GridPane facultyPane) {
		FacultyPane = facultyPane;
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
	

	public TextField getIdField() {
		return idField;
	}

	public void setIdField(TextField idField) {
		this.idField = idField;
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



	public ComboBox<String> getTileList() {
		return tileList;
	}

	public void setTileList(ComboBox<String> tileList) {
		this.tileList = tileList;
	}

	public TextField getSalaryField() {
		return salaryField;
	}

	public void setSalaryField(TextField salaryField) {
		this.salaryField = salaryField;
	}

	public TextField getOfficeAddressField() {
		return officeAddressField;
	}

	public void setOfficeAddressField(TextField officeAddressField) {
		this.officeAddressField = officeAddressField;
	}

	public TextField getPhoneNumberField() {
		return phoneNumberField;
	}

	public void setPhoneNumberField(TextField phoneNumberField) {
		this.phoneNumberField = phoneNumberField;
	}

	public HBox getButtonBox() {
		return buttonBox;
	}

	public void setButtonBox(HBox buttonBox) {
		this.buttonBox = buttonBox;
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
		this.searchBtn = searchBtn;
	}

	public Button getRemoveBtn() {
		return removeBtn;
	}

	public void setRemoveBtn(Button removeBtn) {
		this.removeBtn = removeBtn;
	}

	public Button getUpdateBtn() {
		return updateBtn;
	}

	public void setUpdateBtn(Button updateBtn) {
		this.updateBtn = updateBtn;
	}

	
	
	

}