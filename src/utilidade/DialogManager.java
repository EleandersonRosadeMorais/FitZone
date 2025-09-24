package utilidade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogManager {
    
    public static void showSuccessDialog(Component parent, String message) {
        showCustomDialog(parent, message, "✅ Sucesso", new Color(46, 204, 113));
    }
    
    public static void showErrorDialog(Component parent, String message) {
        showCustomDialog(parent, message, "❌ Erro", new Color(231, 76, 60));
    }
    
    public static void showInfoDialog(Component parent, String message) {
        showCustomDialog(parent, message, "ℹ️ Informação", new Color(52, 152, 219));
    }
    
    public static void showWarningDialog(Component parent, String message) {
        showCustomDialog(parent, message, "⚠️ Aviso", new Color(241, 196, 15));
    }
    
    private static void showCustomDialog(Component parent, String message, String title, Color color) {
        // Encontrar a janela pai
        Window parentWindow = SwingUtilities.getWindowAncestor(parent);
        JDialog dialog = new JDialog(parentWindow, title, Dialog.ModalityType.APPLICATION_MODAL);
        
        // Painel principal
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(color, 2),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        // Ícone
        JLabel iconLabel = new JLabel(title.split(" ")[0]);
        iconLabel.setFont(new Font("Segoe UI", Font.PLAIN, 28));
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Mensagem
        JTextArea messageArea = new JTextArea(message);
        messageArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        messageArea.setBackground(Color.WHITE);
        messageArea.setForeground(new Color(50, 50, 50));
        messageArea.setWrapStyleWord(true);
        messageArea.setLineWrap(true);
        messageArea.setEditable(false);
        messageArea.setFocusable(false);
        
        // Painel da mensagem
        JPanel messagePanel = new JPanel(new BorderLayout(10, 10));
        messagePanel.add(iconLabel, BorderLayout.NORTH);
        messagePanel.add(messageArea, BorderLayout.CENTER);
        messagePanel.setBackground(Color.WHITE);
        
        // Botão OK
        JButton okButton = new JButton("OK");
        okButton.setBackground(color);
        okButton.setForeground(Color.WHITE);
        okButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        okButton.setFocusPainted(false);
        okButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        
        // Efeito hover no botão
        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                okButton.setBackground(color.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                okButton.setBackground(color);
            }
        });
        
        okButton.addActionListener(e -> dialog.dispose());
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(okButton);
        
        // Montagem do diálogo
        panel.add(messagePanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        dialog.setContentPane(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(parent);
        dialog.setResizable(false);
        
        // Animação de fade-in
        applyFadeAnimation(dialog);
        
        dialog.setVisible(true);
    }
    
    private static void applyFadeAnimation(JDialog dialog) {
        if (!isWindowsOS()) {
            return; // Animação só funciona bem no Windows
        }
        
        try {
            dialog.setOpacity(0f);
            Timer timer = new Timer(20, new ActionListener() {
                float opacity = 0f;
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (opacity < 1f) {
                        opacity += 0.1f;
                        dialog.setOpacity(opacity);
                    } else {
                        ((Timer) e.getSource()).stop();
                    }
                }
            });
            timer.start();
        } catch (UnsupportedOperationException e) {
            // Sistema não suporta opacity, ignora animação
        }
    }
    
    private static boolean isWindowsOS() {
        return System.getProperty("os.name").toLowerCase().contains("windows");
    }
    
    // Versão simplificada sem animação (caso precise)
    public static void showSimpleSuccess(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "✅ Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showSimpleError(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "❌ Erro", JOptionPane.ERROR_MESSAGE);
    }
}