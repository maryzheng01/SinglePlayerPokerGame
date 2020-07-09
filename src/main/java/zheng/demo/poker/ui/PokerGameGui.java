package zheng.demo.poker.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import zheng.demo.poker.model.Card;
import zheng.demo.poker.model.Deck;
import zheng.demo.poker.model.HandResult;
import zheng.demo.poker.service.HandEvaluator;
import javax.swing.JScrollPane;

public class PokerGameGui {

	private static final String CARD_5 = "Card 5";
	private static final String CARD_4 = "Card 4";
	private static final String CARD_3 = "Card 3";
	private static final String CARD_2 = "Card 2";
	private static final String CARD_1 = "Card 1";
	private JFrame frame;
	private JTextArea handRankResult;

	private JLabel card1;
	private JLabel card2;
	private JLabel card3;
	private JLabel card4;
	private JLabel card5;

	private Deck deck = new Deck();
	private JButton btnReset;
	private JLabel lblHandranking;
	private JButton btnGetAPoker;
	private JButton btnReDraw;

	private JCheckBox reDrawCard3;
	private JCheckBox reDrawCard4;
	private JCheckBox reDrawCard5;
	private JCheckBox reDrawCard1;
	private JCheckBox reDrawCard2;

	private Card[] rawHand = new Card[5];
	
	HandEvaluator handEvaluator = new HandEvaluator();
	
	private int redrawStartPosition = 5;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PokerGameGui window = new PokerGameGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PokerGameGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 515, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel hand = new JLabel("Poker Hand Ranking:");
		hand.setBounds(276, 70, 101, 14);
		frame.getContentPane().add(hand);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(276, 95, 209, 184);
		frame.getContentPane().add(scrollPane);

		handRankResult = new JTextArea();
		scrollPane.setViewportView(handRankResult);
		
		
		handRankResult.setColumns(10);
		handRankResult.setWrapStyleWord(true);

		deck.prepareADeck();

		btnGetAPoker = new JButton("Get a Poker Hand");
		btnGetAPoker.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				rawHand = deck.drawCards(5);
				Arrays.sort(rawHand);
				showCardsAndRanking();

			}

		});
		btnGetAPoker.setBounds(156, 11, 228, 20);
		frame.getContentPane().add(btnGetAPoker);

		card1 = new JLabel(CARD_1);
		card1.setBounds(118, 70, 108, 14);
		frame.getContentPane().add(card1);

		card2 = new JLabel(CARD_2);
		card2.setBounds(118, 121, 132, 14);
		frame.getContentPane().add(card2);

		card3 = new JLabel(CARD_3);
		card3.setBounds(118, 166, 120, 14);
		frame.getContentPane().add(card3);

		card4 = new JLabel(CARD_4);
		card4.setBounds(118, 213, 164, 14);
		frame.getContentPane().add(card4);

		card5 = new JLabel(CARD_5);
		card5.setBounds(118, 263, 148, 14);
		frame.getContentPane().add(card5);

		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deck.prepareADeck();
				card1.setText(CARD_1);
				card2.setText(CARD_2);
				card3.setText(CARD_3);
				card4.setText(CARD_4);
				card5.setText(CARD_5);
				handRankResult.setText("");
				redrawStartPosition = 5;
			}
		});
		btnReset.setBounds(396, 10, 89, 23);
		frame.getContentPane().add(btnReset);

		lblHandranking = new JLabel("handRanking");
		lblHandranking.setBounds(384, 70, 101, 14);
		frame.getContentPane().add(lblHandranking);

		btnReDraw = new JButton("Re Draw");
		btnReDraw.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent e) {

				outOfCardMessage();
				
				if (reDrawCard1.isSelected()) {
					rawHand[0] = deck.drawACard(redrawStartPosition);
					redrawStartPosition++;
				}
				
				outOfCardMessage();

				if (reDrawCard2.isSelected()) {
					rawHand[1] = deck.drawACard(redrawStartPosition);
					redrawStartPosition++;
				}
				
				outOfCardMessage();

				if (reDrawCard3.isSelected()) {
					rawHand[2] = deck.drawACard(redrawStartPosition);
					redrawStartPosition++;
				}
				outOfCardMessage();

				if (reDrawCard4.isSelected()) {
					rawHand[3] = deck.drawACard(redrawStartPosition);
					redrawStartPosition++;
				}
				
				outOfCardMessage();

				if (reDrawCard5.isSelected()) {
					rawHand[4] = deck.drawACard(redrawStartPosition);
					redrawStartPosition++;
				}

				outOfCardMessage();
				showCardsAndRanking();
			}

		
		});
		btnReDraw.setBounds(22, 10, 89, 23);
		frame.getContentPane().add(btnReDraw);

		reDrawCard1 = new JCheckBox(CARD_1);
		reDrawCard1.setBounds(22, 66, 66, 23);
		frame.getContentPane().add(reDrawCard1);

		reDrawCard2 = new JCheckBox(CARD_2);
		reDrawCard2.setBounds(22, 117, 66, 23);
		frame.getContentPane().add(reDrawCard2);

		reDrawCard3 = new JCheckBox(CARD_3);
		reDrawCard3.setBounds(22, 162, 66, 23);
		frame.getContentPane().add(reDrawCard3);

		reDrawCard4 = new JCheckBox(CARD_4);
		reDrawCard4.setBounds(22, 209, 66, 23);
		frame.getContentPane().add(reDrawCard4);

		reDrawCard5 = new JCheckBox(CARD_5);
		reDrawCard5.setBounds(22, 260, 66, 23);
		frame.getContentPane().add(reDrawCard5);
		
	
	}

	private void showCardsAndRanking() {
		card1.setText(rawHand[0].toString());
		card2.setText(rawHand[1].toString());
		card3.setText(rawHand[2].toString());
		card4.setText(rawHand[3].toString());
		card5.setText(rawHand[4].toString());

		handEvaluator.setHand(rawHand);
		HandResult results = handEvaluator.evaluate();
		lblHandranking.setText(results.getRanking().getName());
		handRankResult.setText(results.showResults());
	}
	
	private void outOfCardMessage() {
		if( redrawStartPosition == 52) {
			JOptionPane.showMessageDialog(null, "OOPs! no more card in Deck, please click Reset!");
		}
	}
}
