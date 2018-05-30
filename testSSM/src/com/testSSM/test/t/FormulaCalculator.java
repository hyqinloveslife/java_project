package com.testSSM.test.t;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

//import com.baidu.ai.api.PhotoRenderUtils;

/**
 * ��������
 * @author hyqin
 *
 */
public class FormulaCalculator {
	private boolean isRightFormat = true;// �ж��Ƿ�����ȷ�ĸ�ʽ
	private String abc = "4+6-2+(5-4)*3-8/4+(5+1)"; //����ֵ15
	
	@Test
	public void test() {
		//String fString = PhotoRenderUtils.getFormulaByPhoto("g:\\1212.png", "1");
//		FormulaCalculator f = new FormulaCalculator();
//		double result = f.getResult(fString);// 
//		System.out.println(result);
	}

	/**
	 * �õ�������
	 * @param format
	 * @return
	 */
	public double getResult(String format) {
		double returnValue = 0;
		try {
			returnValue = doAnalysis(format,"");
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		return returnValue;
	}
	
	/**
	 * �������ֺ����������
	 * @param formula
	 * @return
	 */
	private double doAnalysis(String formula) {
		formula = formula.trim();
		double returnValue = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();

		int calCount = 0;

		int curPos = 0;// ��¼��ǰλ��
		String beforePart = "";
		String afterPart = "";
		String calculator = "";
		isRightFormat = true;
		while (isRightFormat && (formula.indexOf('(')) > 0 || (formula.indexOf(')')) > 0) {
			curPos = 0;
			for (char s : formula.trim().toCharArray()) {
				if (s == '(') {
					stack.add(curPos);
				} else if (s == ')') {
					if (stack.size() > 0) {
						beforePart = formula.substring(0, stack.getLast());
						afterPart = formula.substring(curPos + 1);
						calculator = formula.substring(stack.getLast() + 1, curPos);
						stack.clear();
						break;
					} else {
						System.out.println("��δ�رյ�������");
						isRightFormat = false;
					}
				}
				curPos++;
				System.out.println("��" + calCount++ + "�ɲ���");
			}
			if (stack.size() > 0) {
				System.out.println("��δ�رյ�������");
				break;
			}
		}

		if (isRightFormat) {
			returnValue = doCalculation(formula);
		}

		return returnValue;
	}

	// �������
	private double doCalculation(String formula) {
		ArrayList<Double> values = new ArrayList<Double>();
		ArrayList<String> operators = new ArrayList<String>();

		int curPos = 0;
		int prePos = 0;

		for (char s : formula.trim().toCharArray()) {//���ֺ�������ֿ�
			if (s == '+' || s == '-' || s == '*' || s == '/') {
				values.add(Double.parseDouble(formula.substring(prePos, curPos).trim()));
				operators.add("" + s);
				prePos = curPos + 1;
			}
			curPos++;
		}
		values.add(Double.parseDouble(formula.substring(prePos).trim()));
		char op;
		for (curPos = operators.size() - 1; curPos >= 0; curPos--) {
			op = operators.get(curPos).charAt(0);
			switch (op) {
			case '*':
				values.add(curPos, values.get(curPos) * values.get(curPos + 1));
				values.remove(curPos + 1);
				values.remove(curPos + 1);
				operators.remove(curPos);
				break;
			case '/':
				values.add(curPos, values.get(curPos) / values.get(curPos + 1));
				values.remove(curPos + 1);
				values.remove(curPos + 1);
				operators.remove(curPos);
				break;
			default:
				break;
			}
		}
		//����ӷ��ͼ���Ҫ��ǰ����
		for ( curPos = 0;curPos <= operators.size() ; curPos++) {
			curPos=0;
			op = operators.get(curPos).charAt(0);
			switch (op) {
			case '+':
				values.add(curPos, values.get(curPos) + values.get(curPos + 1));
				values.remove(curPos + 1);
				values.remove(curPos + 1);
				operators.remove(curPos);
				break;
			case '-':
				values.add(curPos, values.get(curPos) - values.get(curPos + 1));
				values.remove(curPos + 1);
				values.remove(curPos + 1);
				operators.remove(curPos);
				break;
			}
		}

		return values.get(0).doubleValue();
	}
	
	/**
	 * overload�������������������
	 * @param formula
	 * @param s
	 * @return
	 */
	private double doAnalysis(String formula, String s) {
		double returnValue = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();

		int curPos = 0;
		String beforePart = "";
		String afterPart = "";
		String calculator = "";
		isRightFormat = true;
		while (isRightFormat && (formula.indexOf('(') >= 0 || formula.indexOf(')') >= 0)) {
			curPos = 0;
			for (char s1 : formula.toCharArray()) {
				if (s1 == '(') {
					stack.add(curPos);
				} else if (s1 == ')') {
					if (stack.size() > 0) {
						beforePart = formula.substring(0, stack.getLast());
						afterPart = formula.substring(curPos + 1);
						calculator = formula.substring(stack.getLast() + 1, curPos);
						formula = beforePart + doCalculation(calculator) + afterPart;
						stack.clear();
						break;
					} else {
						System.out.println("��δ�رյ������ţ�");
						isRightFormat = false;
					}
				}
				curPos++;
			}
			if (stack.size() > 0) {
				System.out.println("��δ�رյ������ţ�");
				break;
			}
		}
		if (isRightFormat) {
			returnValue = doCalculation(formula);
		}
		return returnValue;
	}

}
