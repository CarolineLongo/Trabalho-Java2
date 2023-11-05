// Interface Command
//Neste realizamos o exemplo com pisca-pisca onde o mesmo vai estar ligado ou desligado de acordo o que for da vontade do solicitante executar.
interface Command {
    void execute();
}

// Concrete Command para ligar o pisca-pisca
class TurnOnCommand implements Command {
    private PiscaPisca piscaPisca;

    public TurnOnCommand(PiscaPisca piscaPisca) {
        this.piscaPisca = piscaPisca;
    }

    @Override
    public void execute() {
        piscaPisca.turnOn();
    }
}

// Concrete Command para desligar o pisca-pisca
class TurnOffCommand implements Command {
    private PiscaPisca piscaPisca;

    public TurnOffCommand(PiscaPisca piscaPisca) {
        this.piscaPisca = piscaPisca;
    }

    @Override
    public void execute() {
        piscaPisca.turnOff();
    }
}

// Classe Receptor
class PiscaPisca {
    public void turnOn() {
        System.out.println("Pisca-pisca ligado.");
    }

    public void turnOff() {
        System.out.println("Pisca-pisca desligado.");
    }
}

// Invocador
class RemoteControl {
    private Command onCommand;
    private Command offCommand;

    public RemoteControl(Command onCommand, Command offCommand) {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
    }

    public void turnOn() {
        onCommand.execute();
    }

    public void turnOff() {
        offCommand.execute();
    }
}

public class Main {
    public static void main(String[] args) {
        PiscaPisca piscaPisca = new PiscaPisca();
        Command turnOnCommand = new TurnOnCommand(piscaPisca);
        Command turnOffCommand = new TurnOffCommand(piscaPisca);

        RemoteControl remoteControl = new RemoteControl(turnOnCommand, turnOffCommand);

        remoteControl.turnOn(); // Isso liga o pisca-pisca
        remoteControl.turnOff(); // Isso desliga o pisca-pisca
    }
}