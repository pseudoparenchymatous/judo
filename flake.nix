{
  description = "North Sussex Judo (NSJ): first project in BDSE";

  inputs = {
    nixpkgs.url = "nixpkgs/nixos-unstable";
  };

  outputs = { nixpkgs, ... }: 
  let
    system = "x86_64-linux";
    pkgs = nixpkgs.legacyPackages.${system};

    javac = "${pkgs.jdk}/bin/javac";
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

    packages.${system}.default = pkgs.stdenv.mkDerivation {
      pname = "nsj";
      version = "1.0";
      src = ./src;

      buildPhase = ''
        rm -rf target
        ${javac} -Xlint:none -d target -sourcepath . main/Main.java
      '';

      installPhase = ''
        mkdir -p $out/target
        mv target $out/

        mkdir $out/bin
        cat > $out/bin/nsj << EOF
        #!${pkgs.bash}/bin/bash
        ${pkgs.jdk}/bin/java -cp $out/target main.Main
        EOF

        chmod +x $out/bin/nsj
      '';
    };
  };
}
