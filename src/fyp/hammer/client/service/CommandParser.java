package fyp.hammer.client.service;

import java.util.ArrayList;
import java.util.List;

import fyp.hammer.server.command_type;

public class CommandParser {
	List<String> break_into_array = new ArrayList<String>();
	String _command;

	public CommandParser(String command) {
		_command = command;
		for (String retval: _command.split(" ")){
			break_into_array.add(retval);
		}
	}

	public command_type getCommandType() {
		if (break_into_array.get(0).equals("find")){
			return command_type.SEARCH_BY_TYPE;
		}
		System.out.println(break_into_array.get(0));
		return command_type.UNKNOWN;
	}
	
	public String getParameter() {
		return break_into_array.get(1);
	}
}
