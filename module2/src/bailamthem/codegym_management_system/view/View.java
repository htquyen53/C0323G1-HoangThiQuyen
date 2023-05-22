package bailamthem.codegym_management_system.view;

import bailamthem.codegym_management_system.controller.CodeGymController;

public class View {
    public static void main(String[] args) {
        CodeGymController codeGymController = new CodeGymController();
        codeGymController.showMenu();
    }
}
