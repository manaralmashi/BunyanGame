/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person.bunyan;

import javafx.scene.Scene;

/**
 *
 * @author Murooj
 */
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;
//--------------------------
import javafx.animation.*;
import javafx.scene.effect.BoxBlur;
import javafx.util.Duration;

public class Task3 {

    private HBox Shapes_colorsBox;
    private Shape currentShape;
    String[] ShapesDetails = new String[7];
    Button CancelErrorButton = new Button();
    Button BackToScreenButton = new Button();
    Timeline timeline;
    private Stage stage;
    private TimeAndcoins TCT;  // TCT ->Time and coins and tree
    Start_Interface startLv1 ;
    Task3(Stage stage,TimeAndcoins TCT,Start_Interface startObjectFromLv){
       this.stage= stage ;
       this.startLv1 =startObjectFromLv;
       this.TCT=TCT;

    }
    

    public Scene Task3() {

        //------------------------------------------------------------
        //------------------------------------------------------------
        //RIGHT:
        Rectangle CoinRectangle = new Rectangle(130, 30);
        CoinRectangle.setArcWidth(50);
        CoinRectangle.setArcHeight(50);
        CoinRectangle.setFill(Color.rgb(236, 163, 50, 0.7));

        ImageView Coin = new ImageView(new Image("file:BunyanImages/Murooj/Coin.png"));
        Coin.setFitHeight(50);
        Coin.setFitWidth(50);
        Coin.setTranslateX(40);
        Label CoinLabel = TCT.coinsCounter.getLabel();
        CoinLabel.setTranslateX(-10);
        CoinLabel.setFont(Font.font("Valoon", 22));
        StackPane Coinstack = new StackPane(CoinRectangle, CoinLabel, Coin);

        //------------------------------------------------------------
        Rectangle TimeRectangle = new Rectangle(130, 30);
        TimeRectangle.setArcWidth(50);
        TimeRectangle.setArcHeight(50);
        TimeRectangle.setFill(Color.rgb(236, 163, 50, 0.7));
        ImageView Time = new ImageView(new Image("file:BunyanImages/Murooj/Time.png"));
        Time.setFitHeight(50);
        Time.setFitWidth(50);
        Time.setTranslateX(40);
        Label TimeLabel = TCT.movingTimeCounter.getLabel();
        TimeLabel.setTranslateX(-20);
        TimeLabel.setFont(Font.font("Valoon", 22));
        StackPane Timestack = new StackPane(TimeRectangle, TimeLabel, Time);
        //------------------------------------------------------------
        Rectangle TreeRectangle = new Rectangle(130, 30);
        TreeRectangle.setArcWidth(50);
        TreeRectangle.setArcHeight(50);
        TreeRectangle.setFill(Color.rgb(236, 163, 50, 0.7));
        ImageView Tree = new ImageView(new Image("file:BunyanImages/Murooj/Tree.png"));
        Tree.setFitHeight(50);
        Tree.setFitWidth(50);
        Tree.setTranslateX(40);
        Label TreeLabel = TCT.TreeCounter.getLabel();
        TreeLabel.setTranslateX(-20);
        TreeLabel.setFont(Font.font("Valoon", 22));
        StackPane Treestack = new StackPane(TreeRectangle, TreeLabel, Tree);
        //------------------------------------------------------------
        VBox RightBox = new VBox(15, Coinstack, Timestack, Treestack);
        RightBox.setPadding(new Insets(30, 0, 0, -150));
//------------------------------------------------------------
//------------------------------------------------------------
//Center :
        BorderPane borderPane = new BorderPane();
        HBox layer1Box  = new HBox();
        HBox layer2Box  = new HBox();
        HBox layer3Box  = new HBox();
        HBox layer4Box  = new HBox();
        HBox layer5Box  = new HBox();
        HBox layer6Box  = new HBox();
        HBox layer7Box  = new HBox();
       

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton layer1RadioButton = new RadioButton();
        RadioButton layer2RadioButton = new RadioButton();
        RadioButton layer3RadioButton = new RadioButton();
        RadioButton layer4RadioButton = new RadioButton();
        RadioButton layer5RadioButton = new RadioButton();
        RadioButton layer6RadioButton = new RadioButton();
        RadioButton layer7RadioButton = new RadioButton();

        layer1RadioButton.setToggleGroup(toggleGroup);
        layer2RadioButton.setToggleGroup(toggleGroup);
        layer3RadioButton.setToggleGroup(toggleGroup);
        layer4RadioButton.setToggleGroup(toggleGroup);
        layer5RadioButton.setToggleGroup(toggleGroup);
        layer6RadioButton.setToggleGroup(toggleGroup);
        layer7RadioButton.setToggleGroup(toggleGroup);

        Shapes_colorsBox = new HBox(30);
        Shapes_colorsBox.setAlignment(Pos.CENTER);
        Shapes_colorsBox.setTranslateX(90);
        Shapes_colorsBox.setTranslateY(271);
//------------------------------------------------------------
        //THE BACK RECTANGLE OF THE GAME :
        Rectangle BasicRectangle_T1 = new Rectangle(900, 500);
        BasicRectangle_T1.setArcWidth(50);
        BasicRectangle_T1.setArcHeight(80);
        BasicRectangle_T1.setFill(Color.rgb(221, 239, 218, 0.5));
        BasicRectangle_T1.setTranslateX(-80);
        //------------------------------------------------------------
        //TASK LABAL DESIGN LAYERS  : 
        ImageView WoodenLabelFrame_T1 = new ImageView(new Image("file:BunyanImages/Murooj/WoodenLabelFrame.png"));
        WoodenLabelFrame_T1.setFitHeight(150);
        WoodenLabelFrame_T1.setFitWidth(900);
        Label Task1 = new Label("  Draw the shape shown to you : ");
        Task1.setFont(Font.font("Valoon", 26));
        Rectangle RLabelFrame_T1 = new Rectangle(650, 35);
        RLabelFrame_T1.setArcWidth(50);
        RLabelFrame_T1.setArcHeight(80);
        RLabelFrame_T1.setFill(Color.rgb(236, 163, 50));
        StackPane TaskStack_3 = new StackPane(WoodenLabelFrame_T1, RLabelFrame_T1, Task1);
        TaskStack_3.setTranslateX(-86);
        TaskStack_3.setTranslateY(-270);
        //------------------------------------------------------------ 
        ImageView LayersRB_Background = new ImageView(new Image("file:BunyanImages/Murooj/LayersRB_Background.png"));
        LayersRB_Background.setFitHeight(50);
        LayersRB_Background.setFitWidth(400);
        LayersRB_Background.setTranslateX(-80);
        LayersRB_Background.setTranslateY(-200);

        Image pictureIcon = new Image("file:BunyanImages/Murooj/pictureIcon.png");
        ImageView pictureIconIV = new ImageView(pictureIcon);
        pictureIconIV.setFitHeight(60);
        pictureIconIV.setFitWidth(70);
        pictureIconIV.setTranslateX(360);

        Image OriginalShape = new Image("file:BunyanImages/Murooj/OriginalShape.png");

        Label OriginalShapelabel = new Label(" Original shape ");
        OriginalShapelabel.setFont(Font.font("Valoon", 15));
        OriginalShapelabel.setTranslateX(350);
        OriginalShapelabel.setTranslateY(-35);
//------------------------------------------------------------
        Label LayersLabel = new Label("Layers :");
        LayersLabel.setFont(Font.font("Valoon", 20));
     LayersLabel.setTranslateX(10);
    
     
        HBox LayersRBBox = new HBox(41.5, LayersLabel, layer1RadioButton, layer2RadioButton, layer3RadioButton, layer4RadioButton, layer5RadioButton, layer6RadioButton, layer7RadioButton);
        LayersRBBox.setTranslateX(260);
        LayersRBBox.setTranslateY(190);
  

        StackPane layer1BoxStack = new StackPane(layer1Box, layer2Box, layer3Box, layer4Box, layer5Box, layer6Box, layer7Box);
        layer1BoxStack.setTranslateX(400);
        layer1BoxStack.setTranslateY(300);
        StackPane LayersButtonsStack = new StackPane(LayersRB_Background, LayersRBBox, OriginalShapelabel, pictureIconIV);

        StackPane Centerstack = new StackPane(BasicRectangle_T1, TaskStack_3, layer1BoxStack, LayersButtonsStack);
//------------------------------------------------------------

//Event for layers RB:    
   
        EventRBlayers(layer1RadioButton, layer1Box,1);
        EventRBlayers(layer2RadioButton, layer2Box,2);
        EventRBlayers(layer3RadioButton, layer3Box,3);
        EventRBlayers(layer4RadioButton, layer4Box,4);
        EventRBlayers(layer5RadioButton, layer5Box,5);
        EventRBlayers(layer6RadioButton, layer6Box,6);
        EventRBlayers(layer7RadioButton, layer7Box,7);

        NodeSize(layer1RadioButton);
        NodeSize(layer2RadioButton);
        NodeSize(layer3RadioButton);
        NodeSize(layer4RadioButton);
        NodeSize(layer5RadioButton);
        NodeSize(layer6RadioButton);
        NodeSize(layer7RadioButton);

        //Event for  picture Icon
        // Set action on mouse enter
        pictureIconIV.setOnMouseEntered(event -> {
            pictureIconIV.setFitHeight(190);
            pictureIconIV.setFitWidth(340);
            pictureIconIV.setImage(OriginalShape);
        });
        // Set action on mouse exit
        pictureIconIV.setOnMouseExited(event -> {
            pictureIconIV.setFitHeight(60);
            pictureIconIV.setFitWidth(70);
            pictureIconIV.setImage(pictureIcon);
        });

//------------------------------------------------------------
//------------------------------------------------------------
//LEFT :
        ImageView ShapesColorRB_BG = new ImageView(new Image("file:BunyanImages/Murooj/ShapesColorRB_BG.png"));
        ShapesColorRB_BG.setFitHeight(300);
        ShapesColorRB_BG.setFitWidth(200);
        ShapesColorRB_BG.setTranslateX(100);

        Label RectangleLabel = new Label("Rectangle");
        RectangleLabel.setFont(Font.font("Valoon", 15));
        RectangleLabel.setTextFill(Color.rgb(242, 242, 242));

        Label TriangleLabel = new Label("Triangle");
        TriangleLabel.setFont(Font.font("Valoon", 15));
        TriangleLabel.setTextFill(Color.rgb(242, 242, 242));

        Label CircleLabel = new Label(" Circle");
        CircleLabel.setFont(Font.font("Valoon", 15));
        CircleLabel.setTextFill(Color.rgb(242, 242, 242));

        VBox shepeLabelBox = new VBox(100, RectangleLabel, TriangleLabel, CircleLabel);
        shepeLabelBox.setTranslateX(240);
        shepeLabelBox.setTranslateY(231);

        StackPane LeftStack = new StackPane(ShapesColorRB_BG, shepeLabelBox, Shapes_colorsBox);
//------------------------------------------------------------   
//------------------------------------------------------------
//BOTTOM:
        ImageView PreviousIcon = new ImageView(new Image("file:BunyanImages/Murooj/PreviousIcon.png"));
        ImageView NextIcon = new ImageView(new Image("file:BunyanImages/Murooj/NextIcon.png"));
        PreviousIcon.setFitHeight(90);
        PreviousIcon.setFitWidth(90);
        NextIcon.setFitHeight(90);
        NextIcon.setFitWidth(90);

        Button PreviousButton = new Button();
        PreviousButton.setGraphic(PreviousIcon);
        PreviousButton.setStyle("-fx-background-color: transparent;");
        Button NextButton = new Button();
        NextButton.setGraphic(NextIcon);
        NextButton.setStyle("-fx-background-color: transparent;");
        NextButton.setDisable(true);

        NodeSize(PreviousButton);
        NodeSize(NextButton);

        Button SubmitButton = new Button();
        ImageView SubmitImage = new ImageView(new Image("file:BunyanImages/Murooj/SubmitImage.png"));
        SubmitImage.setFitHeight(95);
        SubmitImage.setFitWidth(150);
        SubmitButton.setGraphic(SubmitImage);
        SubmitButton.setStyle("-fx-background-color: transparent;");
        SubmitButton.setTranslateX(-190);
        SubmitButton.setTranslateY(-80);
        NodeSize(SubmitButton);

        HBox BottombuttonsBox = new HBox(PreviousButton, NextButton, SubmitButton);
        BottombuttonsBox.setPadding(new Insets(-200, 0, 0, 700));

//------------------------------------------------------------
//------------------------------------------------------------
        //---------------------------------------------------------- 
        SubScene CompletionScreen = new SubScene(subScreenStack(), 800, 600);
        CompletionScreen.setFill(Color.TRANSPARENT);
        CompletionScreen.setTranslateX(-10);
        //Activate preventing the sub-screen from appearing except after a specific event
        CompletionScreen.setVisible(false);
        //------------------------------------------------------------
//------------------------------------------------------------

        SubScene SubErrorScreen = new SubScene(SubScreenError(), 800, 600);
        SubErrorScreen.setFill(Color.TRANSPARENT);
        SubErrorScreen.setTranslateX(-10);
        //Activate preventing the sub-screen from appearing except after a specific event
        SubErrorScreen.setVisible(false);
//------------------------------------------------------------
//------------------------------------------------------------   


/*
In this part of the code, all shapes stored in the seven layers will be compared with the correct shapes, 
and the comparison will be using the details of each shape present in the layers in the ShapesDetails variable.

-The task will be completed if all the shapes in the layers match the original shape and meet the mentioned rules.
-Otherwise, if one of the layers is empty, a non-matching error message will appear and the coins will be deducted

   */
           SubmitButton.setOnAction(event -> {
            String inf[] = new String[7];
            inf[0] = "Rectangle - Color: 0xf4b183ff";
            inf[1] = "Rectangle - Color: 0xebe1ffff";
            inf[2] = "Triangle - Color: 0xbdd7eeff";
            inf[3] = "Rectangle - Color: 0xe2f0d9ff";
            inf[4] = "Circle - Color: 0xffe699ff";
            inf[5] = "Circle - Color: 0x7c7c7cff";
            inf[6] = "Rectangle - Color: 0xf05454ff";

            if (ShapesDetails[0] == null || ShapesDetails[1] == null || ShapesDetails[2] == null || ShapesDetails[3] == null || ShapesDetails[4] == null || ShapesDetails[5] == null || ShapesDetails[6] == null) {
                TCT.setCoins(-5);
                TCT.setTree(TCT.getCoins());
                BoxBlur blur = new BoxBlur(10, 10, 3);
                borderPane.setEffect(blur);
                SubErrorScreen.setVisible(true);
            } else {
                if (ShapesDetails[0].equals(inf[0]) & ShapesDetails[1].equals(inf[1]) & ShapesDetails[2].equals(inf[2]) & ShapesDetails[3].equals(inf[3]) & ShapesDetails[4].equals(inf[4]) & ShapesDetails[5].equals(inf[5]) & ShapesDetails[6].equals(inf[6])) {
                    TCT.timeline.stop();
                    BoxBlur blur = new BoxBlur(10, 10, 3);
                    borderPane.setEffect(blur);
                    TCT.setCoins(20);
                    TCT.setTree(TCT.getCoins());
                    CompletionScreen.setVisible(true);        
                    TCT.setTotalGameTime(TCT.getTimeCounter());
                    timeline.play();
                } else {
                    BoxBlur blur = new BoxBlur(10, 10, 3);
                    TCT.setCoins(-5);
                    TCT.setTree(TCT.getCoins());
                    borderPane.setEffect(blur);
                    SubErrorScreen.setVisible(true);
                    TCT.timeline.stop();
                    TCT.setTotalGameTime(TCT.getTimeCounter());
                }
            }
        });

        BackToScreenButton.setOnAction(event -> {
            CompletionScreen.setVisible(false);
            borderPane.setEffect(null);
            NextButton.setDisable(false);
            PreviousButton.setDisable(true);
            SubmitButton.setDisable(true);
       
        });
        CancelErrorButton.setOnAction(event -> {
            SubErrorScreen.setVisible(false);
            borderPane.setEffect(null);
            TCT.timeline.play();
        });
        NodeSize(BackToScreenButton);
        NodeSize(CancelErrorButton);

//------------------------------------------------------------      
         Image SceneBackground = new Image("file:BunyanImages/Murooj/background2.jpg");
        BackgroundSize size = new BackgroundSize(1500, 800, false, false, false, false);
        Background background = new Background(new BackgroundImage(SceneBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));

//------------------------------------------------------------
        borderPane.setRight(RightBox);
        borderPane.setCenter(Centerstack);
        borderPane.setLeft(LeftStack);
        borderPane.setBottom(BottombuttonsBox);
        borderPane.setBackground(background);

        StackPane rootStackPane = new StackPane(borderPane, SubErrorScreen, CompletionScreen);

        Scene scene = new Scene(rootStackPane, 1500, 800);

        PreviousButton.setOnAction(event -> {
            stage.setScene(new Rules(stage, TCT,startLv1).Rules(3));
            TCT.setCoins(-5);
            TCT.setTree(TCT.getCoins());
        });

        NextButton.setOnAction(event -> {
            stage.setScene(new EndOFLevel1(stage, TCT,startLv1).EndOFLevel3());
            TCT.timeline.play();
        });

        return scene;

    }

    
    //STEPS AND CLARIFICATION OF HOW TO WORK THE METHODS: 
   
 /* 
    -When selecting any of the layers using the RadioButton ->
        The program has moved to the--> EventRBlayers method
           This method unpacks the box for displaying shapes 
              and colors on the left of the screen 
    -AND The program then switches to the--> isSelectedShape_Color method 
          This method does the following :
          1]Create a ComboBox of colors for each shape and add them inside the main box that will 
             be displayed on the screen (Shapes_colorsBox)
    
          2]Select any chosen shape and then create a new object from the same selection and store it inside the 
            currentShape variable, in addition to specifying the shape’s sizes based on the current layer.
    
          3]The updateShapeColor and addShape methods are called
             updateShapeColor ->
             addShape -> You add the chosen and created shape into its layer box
             AND  moved to the updateShape method-> (It updates the shape if the user changes his choice)
    
           4] Then after that, there are many events to color the chosen shape and update its 
                color if changed using the--> getColor method.
    
           5]Then the--> updateShapeColor method is used to update the color details of a selected shape 
               using the --> ShapeDetails method, which returns text containing information about the chosen 
               shape (its type and color).
    */
    
    private void EventRBlayers(RadioButton layerRadioButton, HBox layerBox, int i) {
        layerRadioButton.setOnAction(event -> {
            if (layerRadioButton.isSelected()) {
                Shapes_colorsBox.getChildren().clear();
                isSelectedShape_Color(layerBox, i, ShapesDetails[i - 1]);
            }
        });
    }

    private void isSelectedShape_Color(HBox layerBox, int LayerNumber, String d) {
        VBox ShapBox = new VBox(100);
        VBox ColorBox = new VBox(84);

        RadioButton rectangleBtn = new RadioButton();
        RadioButton triangleBtn = new RadioButton();
        RadioButton circleBtn = new RadioButton();

        ToggleGroup toggleGroup = new ToggleGroup();
        rectangleBtn.setToggleGroup(toggleGroup);
        triangleBtn.setToggleGroup(toggleGroup);
        circleBtn.setToggleGroup(toggleGroup);

        ComboBox<String> rectangleColorCB = new ComboBox<>();
        rectangleColorCB.getItems().addAll("Red", "Dark gray", "Yellow", "Light green", "Light Blue", "Purple", "Orange");
        rectangleColorCB.setValue("Yellow");
        rectangleColorCB.setStyle("-fx-background-color: #DFB54E; -fx-font-family: 'Valoon'; -fx-font-size: 12pt;");
        rectangleBtn.setSelected(false);

        ComboBox<String> triangleColorCB = new ComboBox<>();
        triangleColorCB.getItems().addAll("Red", "Dark gray", "Yellow", "Light green", "Light Blue", "Purple", "Orange");
        triangleColorCB.setValue("Yellow");
        triangleColorCB.setStyle("-fx-background-color: #DFB54E; -fx-font-family: 'Valoon'; -fx-font-size: 12pt;");

        ComboBox<String> circleColorCB = new ComboBox<>();
        circleColorCB.getItems().addAll("Red", "Dark gray", "Yellow", "Light green", "Light Blue", "Purple", "Orange");
        circleColorCB.setValue("Purple");
        circleColorCB.setStyle("-fx-background-color: #DFB54E; -fx-font-family: 'Valoon'; -fx-font-size: 12pt;");

        ShapBox.getChildren().addAll(rectangleBtn, triangleBtn, circleBtn);
        ColorBox.getChildren().addAll(rectangleColorCB, triangleColorCB, circleColorCB);

        //------------------------------------------------------------------- 
        //Change the sizes of shapes according to the layer number :
        int w;//Width
        int h;//Height
        int r;//Radius
        switch (LayerNumber) {
            case 1: r = 70; w = 350;h = 150;
                break;
            case 2:
                r = 70; w = 320; h = 120;
                break;
            case 3: r = 75; w = 220; h = 120;
                break;
            case 4:r = 70; w = 290;h = 55;
                break;
            case 5:r = 60; w = 50;h = 100;
                break;
            case 6: r = 50;w = 50;h = 100;
                break;
            case 7:r = 70; w = 30; h = 100;
                break;
            default:
                throw new AssertionError();
        }

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == rectangleBtn) {
              Color selectedColor = getColor(rectangleColorCB.getValue());
                currentShape = new Rectangle(w, h);

                switch (LayerNumber) {
                    case 1:
                        currentShape.setTranslateX(15);
                        currentShape.setTranslateY(30);
                        break;
                    case 2:

                        currentShape.setTranslateX(29);
                        currentShape.setTranslateY(45);
                        break;
                    case 4:
                        currentShape.setTranslateX(45);
                        currentShape.setTranslateY(60);
                        break;
                    case 7:
                        currentShape.setTranslateX(150);
                        currentShape.setTranslateY(80);
                        break;

                }
          
                addShape(currentShape, layerBox);

            } else if (newValue == triangleBtn) {
                currentShape = new Polygon(200.0, 200.0, 100.0, 20.0, 300.0, 20.0);
                currentShape.setRotate(180);
                currentShape.setTranslateX(85);

                addShape(currentShape, layerBox);
            } else if (newValue == circleBtn) {
                currentShape = new Circle(200, 200, r);
                currentShape.setTranslateX(124);
                currentShape.setTranslateY(40);

                addShape(currentShape, layerBox);
            }
        });
        
        
        //The Event for changing and updating the color of the shape

        rectangleColorCB.setOnAction(event -> {
            // test if an object (currentShape)is an instance of a particular class(Rectangle)
            if (currentShape instanceof Rectangle) {
                Color selectedColor = getColor(rectangleColorCB.getValue());
                updateShapeColor(currentShape, selectedColor,LayerNumber);
            }
        });

        triangleColorCB.setOnAction(event -> {
            // test if an object (currentShape)is an instance of a particular class(Polygon)
            if (currentShape instanceof Polygon) {
                Color selectedColor = getColor(triangleColorCB.getValue());
                updateShapeColor(currentShape, selectedColor,LayerNumber);
            }
        });

        circleColorCB.setOnAction(event -> {
               // test if an object (currentShape)is an instance of a particular class(Polygon)
            if (currentShape instanceof Circle) {
                Color selectedColor = getColor(circleColorCB.getValue());
                updateShapeColor(currentShape, selectedColor,LayerNumber);
            }
        });
        

       
        Shapes_colorsBox.getChildren().addAll(ColorBox, ShapBox);
    }

    private void addShape(Shape shape, HBox layerBox) {
        layerBox.getChildren().add(shape);
        updateShape(shape, layerBox);
    }

    private void updateShape(Shape selectedShape, HBox layerBox) {
        layerBox.getChildren().clear();
        layerBox.getChildren().add(selectedShape);
    }

    private void updateShapeColor(Shape shape, Color color, int LayerNumber) {

        shape.setFill(color);
        switch (LayerNumber) {
            case 1:
                ShapesDetails[0] = ShapeDetails(shape, color);
                break;
            case 2:
                ShapesDetails[1] = ShapeDetails(shape, color);
                break;
            case 3:
                ShapesDetails[2] = ShapeDetails(shape, color);
                break;
            case 4:
                ShapesDetails[3] = ShapeDetails(shape, color);
                break;
            case 5:
                ShapesDetails[4] = ShapeDetails(shape, color);
                break;
            case 6:
                ShapesDetails[5] = ShapeDetails(shape, color);
                break;
            case 7:
                ShapesDetails[6] = ShapeDetails(shape, color);
                break;
        }

    }

    private Color getColor(String colorString) {
        switch (colorString) {
            case "Red":
                return Color.rgb(240, 84, 84);
            case "Dark gray":
                return Color.rgb(124, 124, 124);

            case "Yellow":
                return Color.rgb(255, 230, 153);

            case "Light green":
                return Color.rgb(226, 240, 217);

            case "Light Blue":
                return Color.rgb(189, 215, 238);

            case "Purple":
                return Color.rgb(235, 225, 255);

            case "Orange":
                return Color.rgb(244, 177, 131);

            default:
                return Color.BLACK;
        }
    }

    private String ShapeDetails(Shape shape, Color color) {
        String shapeType;

        if (shape instanceof Rectangle) {
            shapeType = "Rectangle";
        } else if (shape instanceof Polygon) {
            shapeType = "Triangle";
        } else if (shape instanceof Circle) {
            shapeType = "Circle";
        } else {
            shapeType = "No Shape";
        }

        return shapeType + " - Color: " + color;
    }

    private StackPane subScreenStack() {
        //Details of a sub-screen that appears to the user when the task is solved correctly :
        ImageView task1completion = new ImageView(new Image("file:BunyanImages/Murooj/taskcompletion.png"));
        task1completion.setFitHeight(520);
        task1completion.setFitWidth(720);

        ImageView Bar = new ImageView(new Image("file:BunyanImages/Murooj/Bar.png"));
        Bar.setFitHeight(150);
        Bar.setFitWidth(570);
        Bar.setTranslateY(-200);

        Label GoodJobLabal = new Label("Good Job ! ");
        GoodJobLabal.setTextFill(Color.rgb(132, 60, 12));
        GoodJobLabal.setFont(Font.font("Valoon", 75));
        GoodJobLabal.setTranslateX(20);
        GoodJobLabal.setTranslateY(-197);

        Label GoodJobShade = new Label("Good Job ! ");
        GoodJobShade.setTextFill(Color.rgb(197, 90, 17));
        GoodJobShade.setFont(Font.font("Valoon", 75));
        GoodJobShade.setTranslateX(20);
        GoodJobShade.setTranslateY(-190);

        StackPane Barstack = new StackPane(Bar, GoodJobShade, GoodJobLabal);
        ScaleTransition MoveBarstack = new ScaleTransition(Duration.seconds(1), Barstack);
        MoveBarstack.setByX(0.1);
        MoveBarstack.setCycleCount(ScaleTransition.INDEFINITE);
        MoveBarstack.setAutoReverse(true);
        MoveBarstack.play();
        //-------------------------------------
        ImageView Beam = new ImageView(new Image("file:BunyanImages/Murooj/Beam.png"));
        Beam.setFitHeight(240);
        Beam.setFitWidth(600);
        Beam.setTranslateY(30);
        ScaleTransition MoveBeam = new ScaleTransition(Duration.seconds(1.5), Beam);
        MoveBeam.setByX(0.03);
        MoveBeam.setCycleCount(ScaleTransition.INDEFINITE);
        MoveBeam.setAutoReverse(true);
        MoveBeam.play();

        Label TaskMessage1 = new Label("You have completed \n the Third Task of the\n           level 1");
        TaskMessage1.setTextFill(Color.rgb(27, 144, 96));
        TaskMessage1.setFont(Font.font("Starborn", 25));
        TaskMessage1.setTranslateY(20);

        Label TaskMessage1Shade = new Label("You have completed \n the Third Task of the\n           level 1");
        TaskMessage1Shade.setTextFill(Color.rgb(201, 201, 201));
        TaskMessage1Shade.setFont(Font.font("Starborn", 25));
        TaskMessage1Shade.setTranslateY(16);

        Label ThirdTask = new Label("  Third Task ");
        ThirdTask.setTextFill(Color.rgb(89, 18, 5));
        ThirdTask.setFont(Font.font("Starborn", 25));
        ThirdTask.setTranslateY(17);
        ThirdTask.setTranslateX(-24);

        ImageView BackToScreenImagone = new ImageView(new Image("file:BunyanImages/Murooj/BackToScreenImagone.png"));
        BackToScreenImagone.setFitHeight(110);
        BackToScreenImagone.setFitWidth(110);
        BackToScreenImagone.setTranslateX(320);
        BackToScreenImagone.setTranslateY(13);

        ProgressBar progressBar = new ProgressBar(0);
        progressBar.setStyle("-fx-accent: green;");
        progressBar.setTranslateY(-3);
        progressBar.setTranslateX(2);
        progressBar.setPrefWidth(365);
        progressBar.setPrefHeight(18);

        ImageView progressBarimge = new ImageView(new Image("file:BunyanImages/Murooj/progressBarimge.png"));
        progressBarimge.setFitHeight(50);
        progressBarimge.setFitWidth(400);

        StackPane progressBarstack = new StackPane(progressBarimge, progressBar);
        progressBarstack.setTranslateY(170);

        Duration duration = Duration.seconds(4);
        timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progressBar.progressProperty(), 0.6)),
                new KeyFrame(duration, new KeyValue(progressBar.progressProperty(), 1))
        );

        StackPane TaskMessage1stack = new StackPane(Beam, TaskMessage1Shade, TaskMessage1, ThirdTask, BackToScreenImagone, progressBarstack);

        //--------------------------------------
         ImageView BackToScreenImag3 = new ImageView(new Image("file:BunyanImages/Murooj/NextIcon.png"));
        BackToScreenImag3.setFitHeight(90);
        BackToScreenImag3.setFitWidth(90);

        BackToScreenButton.setGraphic(BackToScreenImag3);
        BackToScreenButton.setStyle("-fx-background-color: transparent;");
        BackToScreenButton.setTranslateX(320);
        BackToScreenButton.setTranslateY(13);
        //--------------------------------------
        StackPane subScreenStack = new StackPane(task1completion, Barstack, TaskMessage1stack, BackToScreenButton);
        subScreenStack.setStyle("-fx-background-color: transparent;");
        return subScreenStack;
    }

    private StackPane SubScreenError() {
        ///SUB-SCENE(Error) :

        //Details of a sub-screen that appears to the user when the task is solved correctly :
        ImageView MessageBackground = new ImageView(new Image("file:BunyanImages/Murooj/MessageBackground.png"));
        MessageBackground.setFitHeight(520);
        MessageBackground.setFitWidth(720);

        ImageView XimageShade = new ImageView(new Image("file:BunyanImages/Murooj/XimageShade.png"));
        XimageShade.setFitHeight(200);
        XimageShade.setFitWidth(250);
        XimageShade.setTranslateY(-200);
        XimageShade.setTranslateX(20);

        ImageView Ximage = new ImageView(new Image("file:BunyanImages/Murooj/Ximage.png"));
        Ximage.setFitHeight(180);
        Ximage.setFitWidth(220);
        Ximage.setTranslateY(-200);
        Ximage.setTranslateX(19);

        StackPane Xstack = new StackPane(XimageShade, Ximage);
        ScaleTransition MoveXstack = new ScaleTransition(Duration.seconds(1), Xstack);
        // To set an amount to increase the size of the shape
        MoveXstack.setByX(0.05);

        // To Set the iteration to be continuous
        MoveXstack.setCycleCount(ScaleTransition.INDEFINITE);
        // To restart the iteration
        MoveXstack.setAutoReverse(true);
        // Start iteration
        MoveXstack.play();

        //-------------------------------------
        Label ErrorMessage = new Label("  Wrong matching \n       try again ! ");
        ErrorMessage.setTextFill(Color.rgb(255, 242, 204));
        ErrorMessage.setFont(Font.font("Valoon", 60));
        ErrorMessage.setTranslateY(20);

        Label ErrorMessageShade = new Label("  Wrong matching \n       try again ! ");
        ErrorMessageShade.setTextFill(Color.rgb(27, 144, 96));
        ErrorMessageShade.setFont(Font.font("Valoon", 60));
        ErrorMessageShade.setTranslateY(15);

        ImageView BackToScreenImagSecond = new ImageView(new Image("file:BunyanImages/Murooj/BackToScreenImagone.png"));
        BackToScreenImagSecond.setFitHeight(110);
        BackToScreenImagSecond.setFitWidth(110);
        BackToScreenImagSecond.setTranslateX(285);
        BackToScreenImagSecond.setTranslateY(200);

        StackPane TaskMessage2stack = new StackPane(ErrorMessageShade, ErrorMessage, BackToScreenImagSecond);
        //--------------------------------------
        ImageView BackToScreenImag = new ImageView(new Image("file:BunyanImages/Murooj/NextIcon.png"));
        BackToScreenImag.setFitHeight(90);
        BackToScreenImag.setFitWidth(90);
        //-------------------------------------

        CancelErrorButton.setGraphic(BackToScreenImag);
        CancelErrorButton.setStyle("-fx-background-color: transparent;");
        CancelErrorButton.setTranslateX(285);
        CancelErrorButton.setTranslateY(200);
        //--------------------------------------
        StackPane subScreenStack_Error = new StackPane(MessageBackground, Xstack, TaskMessage2stack, CancelErrorButton);
        subScreenStack_Error.setStyle("-fx-background-color: transparent;");

        return subScreenStack_Error;
    }

      private void NodeSize(Node node) {
        node.setOnMouseEntered(event -> {
            node.setScaleX(1.2);
            node.setScaleY(1.2);
        });

        node.setOnMouseExited(event -> {
            node.setScaleX(1.0);
            node.setScaleY(1.0);
        });

    }

}
