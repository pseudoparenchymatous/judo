{
  description = "Hecking Java!!!! #BatChest";

  inputs = {
    nixpkgs.url = "nixpkgs/nixos-unstable";
  };

  outputs = { nixpkgs, ... }: 
  let
    system = "x86_64-linux";
    pkgs = nixpkgs.legacyPackages.${system};
  in {
    devShells.${system}.default = pkgs.mkShell {
      name = "java-devshell";

      nativeBuildInputs = with pkgs; [
        # Dependencies!
        fish
        jdk
      ];

      shellHook = ''
       echo "Blud is programming in Java 💀💀"
      '';

      # Environment variables
    };
  };
}
