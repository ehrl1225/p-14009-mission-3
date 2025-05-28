package com.back.step11.command;

public class WiseSayingCommand {
    private WiseSayingCommandToken main_command_token;
    private WiseSayingCommandParameterList parameter_list;

    WiseSayingCommand(WiseSayingCommandToken main_command_token, WiseSayingCommandParameterList parameter_list) {
        this.main_command_token = main_command_token;
        this.parameter_list = parameter_list;
    }

    public WiseSayingCommandToken getMainCommandToken() {
        return main_command_token;
    }

    public WiseSayingCommandParameterList getParameterList() {
        return parameter_list;
    }

    public int getIntParameter(String parameter_name) throws RuntimeException {
        WiseSayingCommandParameter parameter = parameter_list.getByName(parameter_name);
        if (parameter == null) {
            throw new RuntimeException("No such parameter: " + parameter_name);
        }
        return parameter.getIntValue();
    }

    public String getStringParameter(String parameter_name) throws RuntimeException {
        WiseSayingCommandParameter parameter = parameter_list.getByName(parameter_name);
        if (parameter == null) {
            throw new RuntimeException("No such parameter: " + parameter_name);
        }
        return parameter.getValue();
    }

}
