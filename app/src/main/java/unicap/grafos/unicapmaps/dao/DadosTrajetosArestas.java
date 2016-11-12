package unicap.grafos.unicapmaps.dao;

import java.util.ArrayList;

import unicap.grafos.unicapmaps.model.Trajeto;

/**
 * Created by uira on 12/11/16.
 */

public class DadosTrajetosArestas{

    private static ArrayList<Trajeto> trajetos;

    public DadosTrajetosArestas(){
        //trajetos.add(new Trajeto(0, 1, A_B));
    }

    public static void criarTrajetos(){
        trajetos = new ArrayList<>();
        trajetos.add(new Trajeto( 0,  1,  A_B));
        trajetos.add(new Trajeto( 0,  3,  A_D));
        trajetos.add(new Trajeto( 0,  4,  A_E));
        trajetos.add(new Trajeto( 0,  5,  A_F));
        trajetos.add(new Trajeto( 0,  6,  A_G));
        trajetos.add(new Trajeto( 0, 17,  A_R));
        trajetos.add(new Trajeto( 0, 19,  A_T));
        trajetos.add(new Trajeto( 0, 20,  A_U));
        trajetos.add(new Trajeto( 0, 21,  A_V));
        trajetos.add(new Trajeto( 1,  2,  B_C));
        trajetos.add(new Trajeto( 1, 15,  B_P));
        trajetos.add(new Trajeto( 2,  7,  C_H));
        trajetos.add(new Trajeto( 2, 15,  C_P));
        trajetos.add(new Trajeto( 4,  5,  E_F));
        trajetos.add(new Trajeto( 4,  6,  E_G));
        trajetos.add(new Trajeto( 4,  7,  E_H));
        trajetos.add(new Trajeto( 4,  8,  E_I));
        trajetos.add(new Trajeto( 4, 17,  E_R));
        trajetos.add(new Trajeto( 4, 19,  E_T));
        trajetos.add(new Trajeto( 4, 20,  E_U));
        trajetos.add(new Trajeto( 5, 11,  F_L));
        trajetos.add(new Trajeto( 5, 13,  F_N));
        trajetos.add(new Trajeto( 5, 17,  F_R));
        trajetos.add(new Trajeto( 5, 18,  F_S));
        trajetos.add(new Trajeto( 5, 19,  F_T));
        trajetos.add(new Trajeto( 6, 12,  G_M));
        trajetos.add(new Trajeto( 6, 17,  G_R));
        trajetos.add(new Trajeto( 6, 18,  G_s));
        trajetos.add(new Trajeto( 6, 19,  G_T));
        trajetos.add(new Trajeto( 6, 21,  G_m));
        trajetos.add(new Trajeto( 6, 23,  G_4));
        trajetos.add(new Trajeto( 7,  8,  H_I));
        trajetos.add(new Trajeto( 7, 15,  H_P));
        trajetos.add(new Trajeto( 8,  9,  I_J));
        trajetos.add(new Trajeto(10, 11,  K_L));
        trajetos.add(new Trajeto(10, 14,  K_O));
        trajetos.add(new Trajeto(10, 22,  K_W));
        trajetos.add(new Trajeto(11, 13,  L_N));
        trajetos.add(new Trajeto(11, 22,  L_W));
        trajetos.add(new Trajeto(12, 21,  M_V));
        trajetos.add(new Trajeto(13, 14,  N_O));
        trajetos.add(new Trajeto(13, 19,  N_T));
        trajetos.add(new Trajeto(15, 20,  P_U));
        trajetos.add(new Trajeto(16, 20,  Q_U));
        trajetos.add(new Trajeto(17, 19,  R_T));
        trajetos.add(new Trajeto(17, 21,  R_m));
        trajetos.add(new Trajeto(18, 19,  S_T));
        trajetos.add(new Trajeto( 1,  0,  B_A));
        trajetos.add(new Trajeto( 3,  0,  D_A));
        trajetos.add(new Trajeto( 4,  0,  E_A));
        trajetos.add(new Trajeto( 5,  0,  F_A));
        trajetos.add(new Trajeto( 6,  0,  G_A));
        trajetos.add(new Trajeto(17,  0,  R_A));
        trajetos.add(new Trajeto(19,  0,  T_A));
        trajetos.add(new Trajeto(20,  0,  U_A));
        trajetos.add(new Trajeto(21,  0,  V_A));
        trajetos.add(new Trajeto( 2,  1,  C_B));
        trajetos.add(new Trajeto(15,  1,  P_B));
        trajetos.add(new Trajeto( 7,  2,  H_C));
        trajetos.add(new Trajeto(15,  2,  P_C));
        trajetos.add(new Trajeto( 5,  4,  F_E));
        trajetos.add(new Trajeto( 6,  4,  G_E));
        trajetos.add(new Trajeto( 7,  4,  H_E));
        trajetos.add(new Trajeto( 8,  4,  I_E));
        trajetos.add(new Trajeto(17,  4,  R_E));
        trajetos.add(new Trajeto(19,  4,  T_E));
        trajetos.add(new Trajeto(20,  4,  U_E));
        trajetos.add(new Trajeto(11,  5,  L_F));
        trajetos.add(new Trajeto(13,  5,  N_F));
        trajetos.add(new Trajeto(17,  5,  R_F));
        trajetos.add(new Trajeto(18,  5,  S_F));
        trajetos.add(new Trajeto(19,  5,  T_F));
        trajetos.add(new Trajeto(12,  6,  M_G));
        trajetos.add(new Trajeto(17,  6,  R_G));
        trajetos.add(new Trajeto(18,  6,  S_G));
        trajetos.add(new Trajeto(19,  6,  T_G));
        trajetos.add(new Trajeto(21,  6,  V_G));
        trajetos.add(new Trajeto(23,  6,  G4_G));
        trajetos.add(new Trajeto( 8,  7,  I_H));
        trajetos.add(new Trajeto(15,  7,  P_H));
        trajetos.add(new Trajeto( 9,  8,  J_I));
        trajetos.add(new Trajeto(11, 10,  L_K));
        trajetos.add(new Trajeto(14, 10,  O_K));
        trajetos.add(new Trajeto(22, 10,  W_K));
        trajetos.add(new Trajeto(13, 11,  N_L));
        trajetos.add(new Trajeto(22, 11,  W_L));
        trajetos.add(new Trajeto(21, 12,  V_M));
        trajetos.add(new Trajeto(14, 13,  O_N));
        trajetos.add(new Trajeto(19, 13,  T_N));
        trajetos.add(new Trajeto(20, 15,  U_P));
        trajetos.add(new Trajeto(20, 16,  U_Q));
        trajetos.add(new Trajeto(19, 17,  T_R));
        trajetos.add(new Trajeto(21, 17,  V_R));
        trajetos.add(new Trajeto(19, 18,  T_S));
    }

    public static ArrayList<Trajeto> getTrajetos() {
        criarTrajetos();
        return trajetos;
    }


    static String[] A_B = {

    };
    static String[] A_D = {

    };
    static String[] A_E = {

    };
    static String[] A_F = {

    };
    static String[] A_G = {

    };
    static String[] A_R = {

    };
    static String[] A_T = {

    };
    static String[] A_U = {

    };
    static String[] A_V = {

    };
    static String[] B_C = {

    };
    static String[] B_P = {

    };
    static String[] C_H = {

    };
    static String[] C_P = {

    };
    static String[] E_F = {

    };
    static String[] E_G = {

    };
    static String[] E_H = {

    };
    static String[] E_I = {

    };
    static String[] E_R = {

    };
    static String[] E_T = {

    };
    static String[] E_U = {

    };
    static String[] F_L = {

    };
    static String[] F_N = {

    };
    static String[] F_R = {

    };
    static String[] F_S = {

    };
    static String[] F_T = {

    };
    static String[] G_M = {

    };
    static String[] G_R = {

    };
    static String[] G_s = {

    };
    static String[] G_T = {

    };
    static String[] G_m = {

    };
    static String[] G_4 = {

    };
    static String[] H_I = {

    };
    static String[] H_P = {

    };
    static String[] I_J = {

    };
    static String[] K_L = {

    };
    static String[] K_O = {

    };
    static String[] K_W = {

    };
    static String[] L_N = {

    };
    static String[] L_W = {

    };
    static String[] M_V = {

    };
    static String[] N_O = {

    };
    static String[] N_T = {

    };
    static String[] P_U = {

    };
    static String[] Q_U = {

    };
    static String[] R_T = {

    };
    static String[] R_m = {

    };
    static String[] S_T = {

    };
    static String[] B_A = {

    };
    static String[] D_A = {

    };
    static String[] E_A = {

    };
    static String[] F_A = {

    };
    static String[] G_A = {

    };
    static String[] R_A = {

    };
    static String[] T_A = {

    };
    static String[] U_A = {

    };
    static String[] V_A = {

    };
    static String[] C_B = {

    };
    static String[] P_B = {

    };
    static String[] H_C = {

    };
    static String[] P_C = {

    };
    static String[] F_E = {

    };
    static String[] G_E = {

    };
    static String[] H_E = {

    };
    static String[] I_E = {

    };
    static String[] R_E = {

    };
    static String[] T_E = {

    };
    static String[] U_E = {

    };
    static String[] L_F = {

    };
    static String[] N_F = {

    };
    static String[] R_F = {

    };
    static String[] S_F = {

    };
    static String[] T_F = {

    };
    static String[] M_G = {

    };
    static String[] R_G = {

    };
    static String[] S_G = {

    };
    static String[] T_G = {

    };
    static String[] V_G = {

    };
    static String[] G4_G = {

    };
    static String[] I_H = {

    };
    static String[] P_H = {

    };
    static String[] J_I = {

    };
    static String[] L_K = {

    };
    static String[] O_K = {

    };
    static String[] W_K = {

    };
    static String[] N_L = {

    };
    static String[] W_L = {

    };
    static String[] V_M = {

    };
    static String[] O_N = {

    };
    static String[] T_N = {

    };
    static String[] U_P = {

    };
    static String[] U_Q = {

    };
    static String[] T_R = {

    };
    static String[] V_R = {

    };
    static String[] T_S = {

    };
}
