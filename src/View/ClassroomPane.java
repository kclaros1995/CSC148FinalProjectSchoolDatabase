package View;

import Model.Classroom;
import Model.College;
import Model.Util;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ClassroomPane {
	private GridPane classroomPane;
	private TextField roomNumberField;
	private TextField capacityField;
	private TextField hasProjectorField;

	private HBox buttonBox;
	private Button insertBtn; 
	private Button searchBtn;
	private Button removeBtn;
	private Button updateBtn;

	public ClassroomPane() {
		classroomPane = new GridPane();
		classroomPane.setHgap(20); 
		classroomPane.setVgap(20);
		classroomPane.setPadding(new Insets(50));
		roomNumberField = new TextField();
		roomNumberField.setPromptText("Room Number");
		roomNumberField.setPrefWidth(100);
		capacityField = new TextField();
		capacityField.setPromptText("Capacity");
		capacityField.setPrefWidth(100);
		hasProjectorField = new TextField();
		hasProjectorField.setPromptText("Projector");
		hasProjectorField.setPrefWidth(100);
		

		
		classroomPane.add(roomNumberField, 0, 0);
		classroomPane.add(capacityField, 3, 0);
		classroomPane.add(hasProjectorField, 6, 0);

		
		
		buttonBox = new HBox(20);
		buttonBox.setAlignment(Pos.CENTER);
		insertBtn = new Button("INSERT");
		insertBtn.setPrefWidth(200);
		searchBtn = new Button("SEARCH");
		searchBtn.setPrefWidth(200);
		removeBtn = new Button("REMOVE");
		removeBtn.setPrefWidth(200);
		updateBtn = new Button("UPDATE");
		updateBtn.setPrefWidth(200);

		
		
		
		classroomPane.add(buttonBox, 0, 8, 10, 1);
		
		insertBtn.setOnAction(e->{
			try {
				Classroom c = new Classroom();
				c.setCapacity(Integer.parseInt(capacityField.getText()));
				c.setHasProjector(Boolean.parseBoolean(hasProjectorField.getText()));
				c.setRoomNumber(roomNumberField.getText());
				Model.College.getClassroomBag().insert(c);
				capacityField.clear();
				hasProjectorField.clear();
				roomNumberField.clear();
			} catch (NumberFormatException e1) {
				Model.Util.failureAlert("Please fill lines, no lines must be left blank");
			}
		
		});
		
		
		updateBtn.setOnAction(e->{;
			Classroom c = (Classroom) College.getClassroomBag().findByClassroomNumber(roomNumberField.getText());
			if(c == null) {
				Model.Util.failureAlert("trouble finding classroom");
				return;
			}
			c.setCapacity(Integer.parseInt(capacityField.getText()));
			c.setHasProjector(Boolean.parseBoolean(hasProjectorField.getText()));
			c.setRoomNumber(roomNumberField.getText());
		});

	}
	
	public void updateField(String roomNumber) {
		
		Classroom search = College.getClassroomBag().findByClassroomNumber(roomNumber);
		if(search == null) {
			Model.Util.failureAlert("trouble findig classroom");
			return;
		}
		roomNumberField.setText(((Classroom) College.getClassroomBag().findByClassroomNumber(roomNumber)).getRoomNumber());
		capacityField.setText(String.valueOf((((Classroom) College.getClassroomBag().findByClassroomNumber(roomNumber)).getCapacity())));
		hasProjectorField.setText(String.valueOf((((Classroom) College.getClassroomBag().findByClassroomNumber(roomNumber)).getHasProjector())));
	}
	
	

	public GridPane getClassroomPane() {
		return classroomPane;
	}

	public void setClassroomPane(GridPane classroomPane) {
		this.classroomPane = classroomPane;
	}

	public TextField getRoomNumberField() {
		return roomNumberField;
	}

	public void setRoomNumberField(TextField roomNumberField) {
		this.roomNumberField = roomNumberField;
	}

	public TextField getCapacityField() {
		return capacityField;
	}

	public void setCapacityField(TextField capacityField) {
		this.capacityField = capacityField;
	}

	public TextField getHasProjectorField() {
		return hasProjectorField;
	}

	public void setHasProjectorField(TextField hasProjectorField) {
		this.hasProjectorField = hasProjectorField;
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
