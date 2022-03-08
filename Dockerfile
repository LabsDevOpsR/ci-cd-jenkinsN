FROM jenkins/jenkins:2.303.3-jdk11
USER root
RUN curl -sSL https://get.docker.com/ | sh
RUN echo -e "jenkins ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers
RUN usermod -a -G docker jenkins
COPY --chown=jenkins:jenkins plugins.txt /usr/share/jenkins/ref/plugins.txt
USER jenkins
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt
COPY seedJob.xml /usr/share/jenkins/ref/jobs/seed-job/config.xml
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

