module com.example.laitihanm_2jfx {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.laitihanm_2jfx to javafx.fxml;
    exports com.example.laitihanm_2jfx;
}