import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// GUI class to make a GUI with a selector screen and submission button
// Class made with the assistance of Google AI and Copilot

public class GUI {
    
    public static void makeGUI(Substitutes substitutes) {
        // Create the frame (main window)
        JFrame frame = new JFrame("Allergen Alert");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        
        // creation of a panel
        JPanel panel = new JPanel();

        // label to display the results of the check function
        JLabel display = new JLabel("");

        // button to activate the check function
        JButton button = new JButton("Check for selected allergens");

        // checkbox for soy allergens
        JCheckBox soyBox = new JCheckBox("Filter for soy allergens");
        soyBox.addItemListener(e -> {
            if (soyBox.isSelected()) {
                substitutes.enableSoy();
            } else {
                substitutes.disableSoy();
            }
        });

        // checkbox for peanut allergens
        JCheckBox peanutBox = new JCheckBox("Filter for peanut allergens");
        peanutBox.addItemListener(e -> {
            if (peanutBox.isSelected()) {
                substitutes.enablePeanuts();
            } else {
                substitutes.disablePeanuts();
            }
        });

        // checkbox for kashrut issues
        JCheckBox kashrutBox = new JCheckBox("Filter for kashrut issues");
        kashrutBox.addItemListener(e -> {
            if (kashrutBox.isSelected()) {
                substitutes.enableKosher();
            } else {
                substitutes.disableKosher();
            }
        });

        // checkbox for vegetarian issues
        JCheckBox vegetarianBox = new JCheckBox("Filter for vegetarian issues");
        vegetarianBox.addItemListener(e -> {
            if (vegetarianBox.isSelected()) {
                substitutes.enableVegetarian();
            } else {
                substitutes.disableVegetarian();
            }
        });


        // action listener for the button to activate the check function and display the results
        button.addActionListener(e -> {
            substitutes.checkAllergens();
            String results;
            if (!soyBox.isSelected() && !peanutBox.isSelected() && !kashrutBox.isSelected() && !vegetarianBox.isSelected()) {
                results = "No filters selected. Please select at least one filter.";
            } else {
                results = substitutes.returnAllAllergens();
            }
            display.setText(results);
            display.revalidate(); // Refresh the label to show the new text
        });

        // Add the checkboxes, diplay panel and button to panel, then panel to the frame
        panel.add(soyBox);
        panel.add(peanutBox);
        panel.add(kashrutBox);
        panel.add(vegetarianBox);
        panel.add(button);
        panel.add(display);
        frame.getContentPane().add(panel);

        // Make the window visible
        frame.setVisible(true);

    }
}
