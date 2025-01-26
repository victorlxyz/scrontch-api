package xyz.victorl.scrontch.users.service;

import xyz.victorl.scrontch.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    @Autowired
    private EmailSenderService emailSenderService;

    public void sendAccountVerificationEmail(User user, String verificationLink) {
        String subject = "Vérification de votre compte";
        String body = String.format(
                "Bonjour %s,\n\n" +
                        "Merci de vous être inscrit sur Scrontch ! \n" +
                        "Pour finaliser votre inscription, veuillez cliquer sur le lien ci-dessous afin de vérifier votre adresse e-mail : \n\n" +
                        "%s\n\n" +
                        "Ce lien expirera dans 24 heures.\n\n" +
                        "Cordialement,\n" +
                        "Scrontch",
                user.getUsername(), verificationLink
        );

        emailSenderService.sendEmail(user.getEmail(), subject, body);
    }

    public void sendAccountValidationEmail(User user) {
        String subject = "Votre compte a été activé avec succès";
        String body = String.format(
                """
                        Bonjour %s,
                        
                        Félicitations ! Votre compte Scrontch est maintenant actif.
                        
                        Voici votre identifiant de connexion :
                        Email : %s
                        Vous pouvez désormais vous connecter à votre compte en utilisant ces informations.
                        
                        Cordialement,
                        Scrontch""",
                user.getUsername(),
                user.getEmail()
        );

        emailSenderService.sendEmail(user.getEmail(), subject, body);
    }

    public void sendPasswordResetEmail(User user, String resetLink) {
        String subject = "Réinitialisation de votre mot de passe";
        String body = String.format(
                """
                        Bonjour %s,
                        
                        Nous avons reçu une demande pour réinitialiser le mot de passe de votre compte.
                        
                        Pour réinitialiser votre mot de passe, veuillez cliquer sur le lien ci-dessous :\s
                        
                        %s
                        
                        Si vous n'êtes pas à l'origine de cette demande, veuillez ignorer ce message.
                        
                        Cordialement,
                        Scrontch""",
                user.getUsername(), resetLink
        );
        emailSenderService.sendEmail(user.getEmail(), subject, body);
    }
}

