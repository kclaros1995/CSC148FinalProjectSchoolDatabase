package View;

import Model.College;
import Model.Name;
import Model.Textbook;
import Model.Util;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class TextbookPane {
	private GridPane textbookPane;
	private TextField titleField;
	private TextField authorFirstNameField;
	private TextField authorMiddleInitialField;
	private TextField authorLastNameField;
	private TextField publisherField;
	private TextField isbnField;
	private TextField priceField;

	private HBox buttonBox;
	private Button insertBtn;
	private Button searchBtn;
	private Button removeBtn;
	private Button updateBtn;

	public TextbookPane() {
		textbookPane = new GridPane();
		textbookPane.setHgap(10);
		textbookPane.setVgap(20);
		textbookPane.setPadding(new Insets(50));
		titleField = new TextField();
		titleField.setPromptText("Title");
		titleField.setPrefWidth(300);
		authorFirstNameField = new TextField();
		authorFirstNameField.setPromptText("Auth. f Name");
		authorFirstNameField.setPrefWidth(160);
		authorMiddleInitialField = new TextField();
		authorMiddleInitialField.setPromptText("M.");
		authorMiddleInitialField.setPrefWidth(80);
		authorLastNameField = new TextField();
		authorLastNameField.setPromptText("Auth. l name");
		authorLastNameField.setPrefWidth(160);
		publisherField = new TextField();
		publisherField.setPromptText("Publisher");
		publisherField.setPrefWidth(100);
		isbnField = new TextField();
		isbnField.setPromptText("ISBN");
		isbnField.setPrefWidth(100);
		priceField = new TextField();
		priceField.setPromptText("Price");
		priceField.setPrefWidth(100);
		
		int i = 0;
		int j = 0;

		textbookPane.add(titleField,i + 3, j,3 , 1);
		
		textbookPane.add(authorFirstNameField, 3, 2);
		textbookPane.add(authorMiddleInitialField, 4, 2);
		textbookPane.add(authorLastNameField, 5, 2);
		
		
		textbookPane.add(publisherField, 3, 4);
		
		textbookPane.add(isbnField,  4, 4);
		textbookPane.add(priceField, 5, 4);

		buttonBox = new HBox(20);
		buttonBox.setAlignment(Pos.CENTER);
		insertBtn = new Button("INSERT");
		insertBtn.setPrefWidth(100);
		searchBtn = new Button("SEARCH");
		searchBtn.setPrefWidth(100);
		removeBtn = new Button("REMOVE");
		removeBtn.setPrefWidth(100);
		updateBtn = new Button("UPDATE");
		updateBtn.setPrefWidth(100);
		
		
		
		buttonBox.setAlignment(Pos.CENTER);
		textbookPane.add(buttonBox, 0, 8, 10, 1);
		
		insertBtn.setOnAction(e->{
			Textbook textbook = new Textbook();
			textbook.setAuthor(authorFirstNameField.getText(), authorMiddleInitialField.getText().charAt(0),
					authorLastNameField.getText());
			textbook.setTitle(titleField.getText());
			textbook.setIsbn(isbnField.getText());
			textbook.setPrice(Double.parseDouble(priceField.getText()));
			textbook.setPublisher(publisherField.getText());
			Model.College.getTextbookBag().insert(textbook);
			authorFirstNameField.clear();
			authorMiddleInitialField.clear();
			authorLastNameField.clear();
			titleField.clear();
			isbnField.clear();
			priceField.clear();
			publisherField.clear();
		});
		
			updateBtn.setOnAction(e->{
				Textbook textbook = (Textbook) College.getTextbookBag().findByIsbn(isbnField.getText());
				if(textbook == null) {
					Model.Util.failureAlert("trouble finding textbook!");
					return;
				}
				textbook.setAuthor(authorFirstNameField.getText(), authorMiddleInitialField.getText().charAt(0),
						authorLastNameField.getText());
				textbook.setTitle(titleField.getText());
				textbook.setIsbn(isbnField.getText());
				textbook.setPrice(Double.parseDouble(priceField.getText()));
				textbook.setPublisher(publisherField.getText());
				
			});
			
			

	}
	public void updateField(String isbn) {
		Textbook search = College.getTextbookBag().findByIsbn(isbn);
		if(search == null) {
			Model.Util.failureAlert("trouble updating textbook!");
			return;
		}
		
		authorFirstNameField.setText( College.getTextbookBag().findByIsbn(isbn).getAuthor().getfName());
		authorMiddleInitialField.setText(String.valueOf(College.getTextbookBag().findByIsbn(isbn).getAuthor().getmInitial()));
		authorLastNameField.setText(College.getTextbookBag().findByIsbn(isbn).getAuthor().getlName());
		titleField.setText(College.getTextbookBag().findByIsbn(isbn).getTitle());
		isbnField.setText(College.getTextbookBag().findByIsbn(isbn).getIsbn());
		priceField.setText(String.valueOf(College.getTextbookBag().findByIsbn(isbn).getPrice()));
		publisherField.setText(College.getTextbookBag().findByIsbn(isbn).getPublisher());

	}


	public GridPane getTextbookPane() {
		return textbookPane;
	}

	public void setTextbookPane(GridPane textbookPane) {
		this.textbookPane = textbookPane;
	}

	public TextField getTitleField() {
		return titleField;
	}

	public void setTitleField(TextField titleField) {
		this.titleField = titleField;
	} 

	public TextField getAuthorFirstNameField() {
		return authorFirstNameField;
	}

	public void setAuthorFirstNameField(TextField authorFirstNameField) {
		this.authorFirstNameField = authorFirstNameField;
	}

	public TextField getAuthorMiddleInitialField() {
		return authorMiddleInitialField;
	}

	public void setAuthorMiddleInitialField(TextField authorMiddleInitialField) {
		this.authorMiddleInitialField = authorMiddleInitialField;
	}

	public TextField getAuthorLastNameField() {
		return authorLastNameField;
	}

	public void setAuthorLastNameField(TextField authorLastNameField) {
		this.authorLastNameField = authorLastNameField;
	}

	public TextField getPublisherField() {
		return publisherField;
	}

	public void setPublisherField(TextField publisherField) {
		this.publisherField = publisherField;
	}

	public TextField getIsbnField() {
		return isbnField;
	}

	public void setIsbnField(TextField isbnField) {
		this.isbnField = isbnField;
	}

	public TextField getPriceField() {
		return priceField;
	}

	public void setPriceField(TextField priceField) {
		this.priceField = priceField;
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
