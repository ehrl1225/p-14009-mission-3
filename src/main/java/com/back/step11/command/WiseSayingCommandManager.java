package com.back.step11.command;

import com.back.step11.WiseSayingParser;

public class WiseSayingCommandManager extends WiseSayingParser {

    public WiseSayingCommandManager(){

    }

    private WiseSayingCommandParameterList getCommandParameterList(){
        WiseSayingCommandParameterList list = new WiseSayingCommandParameterList();
        boolean run = true;
        while(run){
            String name = getStringUntilChar('=');
            String value;
            if (hasChar('&')){
                consumeChar('=');
                value = getStringUntilChar('&');
            }else{
                value = getStringFromChar('=');
                run = false;
            }
            WiseSayingCommandParameter param = new WiseSayingCommandParameter(name, value);
            list.add(param);
        }
        return list;
    }

    public WiseSayingCommand getWiseSayingCommand(String str){
        setString(str);
        String main_command;
        WiseSayingCommandParameterList params;
        if (hasChar('?')){
            main_command = getStringUntilChar('?');
            consumeChar('?');
             params = getCommandParameterList();
        }else{
            main_command = str;
            params = WiseSayingCommandParameterList.emptyList();
        }

        WiseSayingCommandToken main_command_token = switch (main_command) {
            case "종료" -> WiseSayingCommandToken.Terminate;
            case "등록" -> WiseSayingCommandToken.Insert;
            case "목록" -> WiseSayingCommandToken.Show;
            case "삭제" -> WiseSayingCommandToken.Delete;
            case "수정" -> WiseSayingCommandToken.Update;
            case "빌드" -> WiseSayingCommandToken.Build;
            default -> WiseSayingCommandToken.NULL;
        };

        return new WiseSayingCommand(main_command_token, params);
    }
}
