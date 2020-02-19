module Hajin {
    requires javafx.controls;
    requires javafx.fxml;
    opens Hajin to javafx.base, javafx.fxml;
    exports Hajin;
}