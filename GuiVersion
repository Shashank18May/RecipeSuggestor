import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GuiVersion {

    private final Main main;

    private final ArrayList<JCheckBox> ingredientCheckBoxes;
    private JTextArea outputTextArea;
    final JFrame frame;

    public GuiVersion(Main main) {
        this.main = main;

        frame = new JFrame();

        frame.setTitle("Recipe Suggestions");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(240, 240, 240));

        JPanel ingredientPanel = new JPanel();
        ingredientPanel.setLayout(new GridLayout(0, 3));
        ingredientPanel.setBackground(new Color(220, 220, 220));

        outputTextArea = new JTextArea();

        ingredientCheckBoxes = new ArrayList<>();
        for (String ingredient : main.availableIngredients) {
            JCheckBox checkBox = new JCheckBox(ingredient);
            checkBox.setBackground(new Color(220, 220, 220));
            ingredientCheckBoxes.add(checkBox);
            ingredientPanel.add(checkBox);
        }

        JButton suggestButton = new JButton("Suggest Recipes");
        suggestButton.setBackground(new Color(135, 206, 250));
        suggestButton.setForeground(Color.WHITE);
        suggestButton.addActionListener(new SuggestButtonListener());

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        outputPanel.setBackground(new Color(255, 255, 255));
        outputPanel.setBounds(0,450,600,50);

        JLabel outputLabel = new JLabel("Suggested Recipes:");
        outputLabel.setFont(new Font("Arial", Font.BOLD, 16));
        outputLabel.setForeground(new Color(70, 130, 180));
        outputLabel.setBounds(0,450,600,50);
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setFont(new Font("Arial", Font.PLAIN, 24));
        outputTextArea.setBounds(0,450,600,50);
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);

        outputPanel.add(outputLabel, BorderLayout.NORTH);
        outputPanel.add(outputScrollPane, BorderLayout.CENTER);

        frame.add(ingredientPanel, BorderLayout.NORTH);
        frame.add(suggestButton, BorderLayout.SOUTH);
        frame.add(outputPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private class SuggestButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            java.util.List<String> selectedIngredients = getSelectedIngredients();
            List<Main.Recipe> matchingRecipes = main.findMatchingRecipes(selectedIngredients, main.recipes);

            outputTextArea.setText("");

            if (matchingRecipes.isEmpty()) {
                outputTextArea.setText("No recipes found with the selected ingredients.");
            } else {
                for (Main.Recipe recipe : matchingRecipes) {
                    outputTextArea.append("- " + recipe.getName() + "\n");
                }
            }
        }
    }

    private List<String> getSelectedIngredients() {
        List<String> selectedIngredients = new ArrayList<>();

        for (JCheckBox checkBox : ingredientCheckBoxes) {
            if (checkBox.isSelected()) {
                selectedIngredients.add(checkBox.getText());
            }
        }

        return selectedIngredients;
    }
}
