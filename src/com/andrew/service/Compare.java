package com.andrew.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Compare extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get the numbers from request via string
		String input1 = request.getParameter("num1");
		String input2 = request.getParameter("num2");

		String returnVal = getResult(input1, input2);

		PrintWriter out = response.getWriter();
		out.println(returnVal);
	}

	public String getResult(String input1, String input2) {
		// split the number at .
		String[] input1parts = input1.split("\\.");
		String[] input2parts = input2.split("\\.");

		// check the smallest size
		int size = Math.min(input1parts.length, input2parts.length);

		for (var i = 0; i < size; ++i) {
			// parse int
			int fromInput1 = Integer.parseInt(input1parts[i]);
			int fromInput2 = Integer.parseInt(input2parts[i]);

			if (fromInput1 > fromInput2) {
				return input1 + " is after " + input2;
			}
			if (fromInput1 < fromInput2) {
				return input1 + " is before " + input2;
			}
		}

		// length check if all = above
		if (input1parts.length == input2parts.length) {
			return input1 + " is equal " + input2;
		} else if (input1parts.length < input2parts.length) {
			return input1 + " is before " + input2;
		} else {
			return input1 + " is after " + input2;
		}
	}
}
